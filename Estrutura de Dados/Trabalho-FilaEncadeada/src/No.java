public class No {
    
    private ItemCompra item;
    private No no;

    public No() {};

    public No(ItemCompra item) {
        this.item = item;
        this.no = null;
    }

    public ItemCompra getItem() { return item; }
    public void setItem(ItemCompra item) { this.item = item; }
    public No getNo() { return no; }
    public void setNo(No no) { this.no = no; }

}
