public class Balcony extends Seat{ 

  public Balcony(int adultPrice, String comfort, String seatMaterial){
    super.adultPrice = adultPrice;
    super.comfort = comfort;
    super.seatMaterial = seatMaterial;
  }

  @Override
  public void printInfo() {
    System.out.println("This seat is " + this.comfort + " and made out of " + this.seatMaterial + "the prices are listed below (Ages under 21 are prohibited)" + "Adult $" + this.adultPrice);
  }
  
}
