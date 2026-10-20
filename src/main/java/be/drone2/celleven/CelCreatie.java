package be.drone2.celleven;

public class CelCreatie {

    public CelCreatie() {
    }

    public boolean creatieVoorwaardenCheck ( Cel cel1, Cel cel2) {
        int x1 = cel1.getKoppel().getxPositie();
        int y1 = cel1.getKoppel().getyPositie();
        int x2 = cel2.getKoppel().getxPositie();
        int y2 = cel2.getKoppel().getyPositie();
        if ((Math.abs(x1-x2) <= 1 ) && (Math.abs(y1-y2) <= 1)) {

            return true;

        }
        return false;

    }


}
