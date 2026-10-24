package be.drone2.celleven;

public class CelCreatie {

    public CelCreatie() {
    }

    public boolean creatieVoorwaardenCheck(Cel cel1, Cel cel2) {
        double leeftijdcel1 = cel1.getLeeftijd();
        double leeftijdcel2 = cel2.getLeeftijd();
        int x1 = cel1.getKoppel().getXPositie();
        int y1 = cel1.getKoppel().getYPositie();
        int x2 = cel2.getKoppel().getXPositie();
        int y2 = cel2.getKoppel().getYPositie();
        if ((Math.abs(x1 - x2) <= 1) && (Math.abs(y1 - y2) <= 1) && leeftijdcel1 >= 1 && leeftijdcel2 >= 1 && leeftijdcel1 < 6 && leeftijdcel2 < 6) {

            return true;

        }
        return false;

    }

    public void maakNieuweCel(Cel cel1, Cel cel2) {

        int x1 = cel1.getKoppel().getXPositie();
        int y1 = cel1.getKoppel().getYPositie();

        int x2 = cel2.getKoppel().getXPositie();
        int y2 = cel2.getKoppel().getYPositie();

        int grootsteX = Math.max(x1, x2) + 1;
        int grootsteY = Math.max(y1, y2) + 1;
        int kleinsteX = Math.min(x1, x2) - 1;
        int kleinsteY = Math.min(y1, y2) - 1;

        Koppel nieuwGrootsteKoppel = new Koppel(grootsteX, grootsteY);
        Koppel nieuwKleinsteKoppel = new Koppel(kleinsteX, kleinsteY);
        Koppel nieuwKlxGryKoppel = new Koppel(kleinsteX, grootsteY);
        Koppel nieuwGrxKlyKoppel = new Koppel(grootsteX, kleinsteY);
        if ((kleinsteX >= 0) && (kleinsteY >= 0) && !Leefwereld.RASTER.isLevend(nieuwKleinsteKoppel)) {
                Cel nieuweCel = new Cel(nieuwKleinsteKoppel, 0);
                Leefwereld.RASTER.voegCelToe(nieuweCel);
        } else {if (grootsteX < Leefwereld.RASTER.getLengte()
                && grootsteY < Leefwereld.RASTER.getLengte()
                && !Leefwereld.RASTER.isLevend(nieuwGrootsteKoppel)) {

            Cel nieuweCel = new Cel(nieuwGrootsteKoppel, 0);

            Leefwereld.RASTER.voegCelToe(nieuweCel);
            
            } else {
                if ((kleinsteX >= 0) && (grootsteY < Leefwereld.RASTER.getLengte())
                        && !Leefwereld.RASTER.isLevend(nieuwKlxGryKoppel)) {
                    Cel nieuweCel = new Cel(nieuwKlxGryKoppel, 0);
                    Leefwereld.RASTER.voegCelToe(nieuweCel);
                } else {
                    if ((grootsteX < Leefwereld.RASTER.getLengte()) && (kleinsteY >= 0)
                            && !Leefwereld.RASTER.isLevend(nieuwGrxKlyKoppel)) {
                        Cel nieuweCel = new Cel(nieuwGrxKlyKoppel, 0);
                        Leefwereld.RASTER.voegCelToe(nieuweCel);
                    }

                }

            }
        }
    }

}
