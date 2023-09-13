import javax.management.Descriptor;
import java.time.Year;
import java.util.Objects;




public class Product {


    private String pName;
    private String description;
    private String ID;
    private double cost;


    static private int IDseed = 1;

    public static int getIDseed() {
        return IDseed;
    }

    public static void setIDseed(int IDseed) {
        Product.IDseed = IDseed;
    }


    public Product(String ID, String pName, String description, double cost) {
        this.pName = pName;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public Product(String pName, String description, double cost) {
        this.ID = this.genID();
        this.pName = pName;
        this.description = description;
        this.cost = cost;
    }


    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setId(String ID) {
        this.ID = ID;
    }

    private String genID() {
        String newID = "" + IDseed;
        while (newID.length() < 8) {
            newID = "0" + newID;
        }
        IDseed++;
        return newID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Product{" +
                "pName='" + pName + '\'' +
                ", description='" + description + '\'' +
                ", ID='" + ID + '\'' +
                ", YOB=" + cost +
                '}';
    }


    public String toCSVRecord() {
        return ID + ", " + pName + "," + description + ", " + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(pName, product.pName) && Objects.equals(description, product.description) && Objects.equals(ID, product.ID) && Objects.equals(cost, product.cost);
    }

    public String toXMLRecord() {
        String retString = "";

        retString = "<IDNum>" + this.ID + "</IDNum>";
        retString += "<ProductName>" + this.pName + "</ProductName>";
        retString += "<Description>" + this.description + "</Description>";
        retString += "<Cost>" + this.cost + "</Cost>";

        return retString;
    }

    public String toJSONRecord() {
        String retString = "";
        char DQ = '\u0022';  // Assign the double quote char to a variable
        retString = "{" + DQ + "IDNum" + DQ + ":" + DQ + this.ID + DQ + ",";
        retString += DQ + "ProductName" + DQ + ":" + DQ + this.pName + DQ + ",";
        retString += " " + DQ + "Description" + DQ + ":" + DQ + this.description + DQ + ",";
        retString += " " + DQ + "Cost" + DQ + ":" + this.cost + "}";

        return retString;
    }
}

