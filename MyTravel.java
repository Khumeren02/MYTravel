public class MyTravel {

  //declare 2 travel places with 3 spaces each to store sum of each criteria ratings
  private static int[] penthouseKLCC = new int[3];
  private static int[] hotelFalcon = new int[3];

  //declare 3 rating criteria for each travel place with 8 guests to give ratings
  private static int[] cleanlinessPenthouseKLCC = new int[8];
  private static int[] facilitiesPenthouseKLCC = new int[8];
  private static int[] reasonablePricePenthouseKLCC = new int[8];

  private static int[] cleanlinessHotelFalcon = new int[8];
  private static int[] facilitiesHotelFalcon = new int[8];
  private static int[] reasonablePriceHotelFalcon = new int[8];

  //declare variables to store sum of all average ratings for all travel places
  private static int sumPenthouseKLCC;
  private static int sumHotelFalcon;

  //method for the 8 guests to give random ratings
  public static int provideRating() {

    int min = 1, max = 5;

    for (int i = 0; i < 8; i++) {
      cleanlinessPenthouseKLCC[i] = (int)(Math.random() * (max - min + 1) + min);
      facilitiesPenthouseKLCC[i] = (int)(Math.random() * (max - min + 1) + min);
      reasonablePricePenthouseKLCC[i] = (int)(Math.random() * (max - min + 1) + min);

      cleanlinessHotelFalcon[i] = (int)(Math.random() * (max - min + 1) + min);
      facilitiesHotelFalcon[i] = (int)(Math.random() * (max - min + 1) + min);
      reasonablePriceHotelFalcon[i] = (int)(Math.random() * (max - min + 1) + min);
    }
    return 0;
  }

  //method to calculate average ratings for each criteria for each place
  public static int calcAverageRating() {

    //sum of all ratings for criteria is stored in travel place array
    for (int i = 0; i < 8; i++) {
      penthouseKLCC[0] += cleanlinessPenthouseKLCC[i];
      penthouseKLCC[1] += facilitiesPenthouseKLCC[i];
      penthouseKLCC[2] += reasonablePricePenthouseKLCC[i];

      hotelFalcon[0] += cleanlinessHotelFalcon[i];
      hotelFalcon[1] += facilitiesHotelFalcon[i];
      hotelFalcon[2] += reasonablePriceHotelFalcon[i];
    }

    //calculate average of the summation
    for (int i = 0; i < 3; i++) {
      penthouseKLCC[i] = penthouseKLCC[i] / 8;
      hotelFalcon[i] = hotelFalcon[i] / 8;
    }
    return 0;
  }

  //method to sum combined criteria average rating to determine status later
  public static int sumAllCriteriaRatings() {

    for (int i = 0; i < 3; i++) {
      sumPenthouseKLCC += penthouseKLCC[i];
      sumHotelFalcon += hotelFalcon[i];
    }
    return 0;
  }

  //method to determine recommendation status for each travel place
  public static int status() {

    String status1 = "Highly Recommended";
    String status2 = "Somewhat Recommended";
    String status3 = "Not Recommended";

    if (sumPenthouseKLCC < 5)
      System.out.println("Penthouse KLCC is " + status3);
    else if (sumPenthouseKLCC >= 5 && sumPenthouseKLCC < 10)
      System.out.println("Penthouse KLCC is " + status2);
    else
      System.out.println("Penthouse KLCC is " + status1);

    if (sumHotelFalcon < 5)
      System.out.println("Hotel Falcon is " + status3);
    else if (sumHotelFalcon >= 5 && sumHotelFalcon < 10)
      System.out.println("Hotel Falcon is " + status2);
    else
      System.out.println("Hotel Falcon is " + status1);

    return 0;
  }

  public static void main(String[] args) {

    provideRating();
    calcAverageRating();
    sumAllCriteriaRatings();
    status();

  }
}