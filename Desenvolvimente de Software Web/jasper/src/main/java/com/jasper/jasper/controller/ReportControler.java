package com.jasper.jasper.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import com.jasper.jasper.service.ReportService;
import com.jasper.jasper.service.UsuarioService;

@Controller
public class ReportControler {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ReportService reportService;

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

        // JasperExportManager.exportReportToPdfFile(report, "usuarios.pdf"); Exporta o
        // pdf para a mesma pasta do projeto spring.

        byte[] data = JasperExportManager.exportReportToPdf(report);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=usuarios.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);

    }

}
