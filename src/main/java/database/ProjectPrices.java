package database;

public class ProjectPrices {
    public String projectName;
    public int price;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "projectName='" + projectName + '\'' +
                ", price=" + price +
                '}';
    }
}
