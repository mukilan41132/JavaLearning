public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
           this.pagesPrinted = 0;
           this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
           this.duplex = duplex;
    }

    public int addToner(int toneramount) {
          int toner = toneramount + toneramount;
          if(toner > 100 || toner < 0) {
            return -1;
          }
          tonerLevel += toneramount;
          return tonerLevel;
    }

    public int printPages(int pages) {
        int frontorback = (duplex) ? (pages / 2) + (pages % 2) : pages;
        pagesPrinted += frontorback;
        return frontorback;

    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
