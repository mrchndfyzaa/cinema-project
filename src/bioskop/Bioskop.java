package bioskop;

public abstract class Bioskop {
    protected int harga;
    protected double totalHarga;
    private int tanggal;
    private int jumlahKursi;
    
    Bioskop(){
        
    }
    
    Bioskop(int harga, int tanggal, int jumlahKursi){
        this.harga = harga;
        this.tanggal = tanggal;
        this.jumlahKursi = jumlahKursi;
    }
    public int getHarga(){
        return harga;
    }
    
    public int getTanggal(){
        return tanggal;
    }
    
    public int getJumlahKursi(){
        return jumlahKursi;
    }
    
    @Override
    public String toString(){
        return "=====Film Bioskop=====" + "\nHarga Tiket : " + getHarga() + "\nTayang tanggal : " + getTanggal()
                + "\nJumlah Tempat Duduk yang Tersedia : " + getJumlahKursi();
    }
}

class Silver extends Bioskop {
    private String nama;
    private int id;
    private int jumlahOrderKursi;
    private double diskon;
    
    Silver(){
        
    }
    
    Silver(int harga, int tanggal, int jumlahKursi, String nama, int id, int jumlahOrderKursi){
        super(harga, tanggal, jumlahKursi);
        this.nama = nama;
        this.id = id;
        this.jumlahOrderKursi = jumlahOrderKursi;
    }
    
    public String getNama(){
        return nama;
    }
    
    public int getId(){
        return id;
    }
    
    public int getJumlahOrderKursi(){
        return jumlahOrderKursi;
    }
    
    public double getTotalHarga(){
        if(jumlahOrderKursi >= 5){
            totalHarga = getHarga() - (0.1 * getHarga());
        }
        else{
            totalHarga = getHarga();
        }
        return totalHarga;
    }
    
    @Override 
    public String toString(){
        return super.toString() + "\n===Pesanan Anda===" + "\nJenis Akun : Silver" + "\nNama : " + getNama() + "\nID : " + 
                getId() + "\nJumlah Kursi yang Dipesan : " + getJumlahOrderKursi() 
                + "\nTotal Harga : $" + getTotalHarga() + "\n"; 
    }
}

class Gold extends Bioskop {
    private String nama;
    private int id;
    private int jumlahOrderKursi;
    private double diskon;
    private int tanggalPesan;
    private double order;
    
    Gold(){
        
    }
    
    Gold(int harga, int tanggalTayang, int jumlahKursi, String nama, int id, int jumlahOrderKursi, int tanggalPesan){
        super(harga, tanggalTayang, jumlahKursi);
        this.nama = nama;
        this.id = id;
        this.jumlahOrderKursi = jumlahOrderKursi;
        this.tanggalPesan = tanggalPesan;
    }
    
    public String getNama(){
        return nama;
    }
    
    public int getId(){
        return id;
    }
    
    public int getJumlahOrderKursi(){
        return jumlahOrderKursi;
    }
    
    public int getTanggalPesan(){
        return tanggalPesan;
    }
    
    public double getOrder(){
        switch (getTanggal() - getTanggalPesan()) {
            case 3:
                order = 0.1;
                break;
            case 5:
                order = 0.15;
                break;
            case 7:
                order = 0.2;
                break;
            default:
                break;
        }
        return order;
    }
    
    public double getTotalHarga(){
        if(jumlahOrderKursi >= 3){
            totalHarga = getHarga() - (0.15 * getHarga()) + (getOrder() * getHarga());
        }
        else{
            totalHarga = getHarga();
        }
        return totalHarga;
    }
    
    @Override 
    public String toString(){
        return super.toString() + "\n===Pesanan Anda===" + "\nJenis Akun : Gold" + "\nNama : " + getNama() + "\nID : " + 
                getId() + "\nJumlah Kursi yang Dipesan : " + getJumlahOrderKursi() 
                + "\nTotal Harga : $" + getTotalHarga() + "\n"; 
    }
}

class Diamond extends Bioskop {
    private String nama;
    private int id;
    private int jumlahOrderKursi;
    private double diskon;
    private int tanggalPesan;
    private double order;
    private double bonus;
    private static int x;
    
    Diamond(){
        
    }
    
    Diamond(int harga, int tanggalTayang, int jumlahKursi, String nama, int id, int jumlahOrderKursi, int tanggalPesan){
        super(harga, tanggalTayang, jumlahKursi);
        this.nama = nama;
        this.id = id;
        this.jumlahOrderKursi = jumlahOrderKursi;
        this.tanggalPesan = tanggalPesan;
    }
    
    public String getNama(){
        return nama;
    }
    
    public int getId(){
        return id;
    }
    
    public int getJumlahOrderKursi(){
        return jumlahOrderKursi;
    }
    
    public int getTanggalPesan(){
        return tanggalPesan;
    }
    
    public static int generateRandomIntIntRange(double min, double max) {
        x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }
    
    public double getBonus(){
        if(generateRandomIntIntRange(1, 10) == 2){
            bonus = 0.5;
        }
        else{
            bonus = 0;
        }
        return bonus;
    }
    
    public double getOrder(){
        switch (getTanggal() - getTanggalPesan()) {
            case 3:
                order = 0.1;
                break;
            case 5:
                order = 0.15;
                break;
            case 7:
                order = 0.2;
                break;
            default:
                break;
        }
        return order;
    }
    
    public double getTotalHarga(){
        totalHarga = getHarga() - (getBonus() * getHarga()) + (getOrder() * getHarga());
        return totalHarga;
    }
    
    @Override 
    public String toString(){
        return super.toString() + "\n===Pesanan Anda===" + "\nJenis Akun : Diamond" + "\nNama : " + getNama() + "\nID : " + 
                getId() + "\nJumlah Kursi yang Dipesan : " + getJumlahOrderKursi() 
                + "\nTotal Harga : $" + getTotalHarga(); 
    }
}