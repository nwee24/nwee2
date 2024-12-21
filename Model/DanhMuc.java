package Model;

public class DanhMuc {
    private String maDM;
    private String tenDM;
    private int isDelete;

    public DanhMuc(String maDM, String tenDM) {
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.isDelete = 0; // Giá trị mặc định nếu cần
    }

    public DanhMuc() {

    }


    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return this.tenDM;
    }
}
