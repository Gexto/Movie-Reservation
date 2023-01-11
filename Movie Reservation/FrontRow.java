public class FrontRow extends Seat{

  public FrontRow(int childPrice, int adultPrice, String comfort, String seatMaterial){
    super.childPrice = childPrice;
    super.adultPrice = adultPrice;
    super.comfort = comfort;
    super.seatMaterial = seatMaterial;
  }

  @Override
  public void printInfo() {
    System.out.println("This seat can " + this.comfort + ". It is padded with " + this.seatMaterial + ". The prices are listed below" + "\n" + "Child: $" + this.childPrice + "\n" + "Adult: $" + this.adultPrice);
  }
}
