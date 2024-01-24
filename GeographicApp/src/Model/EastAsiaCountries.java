package Model;

public class EastAsiaCountries extends Country {
    private String countryTerrain;
    
    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrian) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrian;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }
    
    @Override
    public void display(){
        super.display();
        System.out.println("Country Terrian: " + countryTerrain);
    }
}
