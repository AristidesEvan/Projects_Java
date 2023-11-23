package com.jasper.jasper.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jasper.jasper.model.Usuario;
import com.jasper.jasper.service.ReportService;
import com.jasper.jasper.service.UsuarioService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ReportService reportService;

    @GetMapping("/")
    public List<Usuario> getAllUsuarios() {

        return usuarioService.getAllUsuarios();

    }

    @PostMapping("/")
    public Usuario insertUsuario(@RequestBody Usuario usuario) {

        return usuarioService.insertUsuario(usuario);

    }

    @PutMapping("/")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {

        return usuarioService.updateUsuario(usuario);

    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {

        usuarioService.deleteUsuario(id);

    }

    // ---------------------

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return reportService.exportReport(format);
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf() throws Exception, JRException {
        // ResponseEntity<byte[]> downloadInvoice()

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
                usuarioService.getAllUsuarios());

        // JasperReport compileReport = JasperCompileManager.compileReport(new
        // FileInputStream("sr/main/resources/usuarios.jrxml"));
        JasperReport compileReport = JasperCompileManager.compileReport(
                this.getClass().getResourceAsStream("/usuarios.jrxml"));

        HashMap<String, Object> map = new HashMap<>();
        JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);

        // JasperExportManager.exportReportToPdfFile(report, "usuarios.pdf"); Exporta o pdf para a mesma pasta do projeto spring.

        byte[] data = JasperExportManager.exportReportToPdf(report);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=usuarios.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);

    }

}
