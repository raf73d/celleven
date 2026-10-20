package be.drone2.celleven;

public enum Leefwereld {
    RASTER(10);
    private final int lengte;
    private boolean[][] rasterveld;

    private Leefwereld(int lengte) {
        this.lengte = lengte;
        this.rasterveld = new boolean[lengte][lengte];

    }

    public int getLengte() {
        return lengte;
    }

    public boolean[][] getRasterveld() {
        return rasterveld;
    }
   
    public boolean isLevend (Koppel koppel){
        return rasterveld[koppel.getxPositie()][koppel.getyPositie()];
    }
    
    public void setLevend (Koppel koppel, boolean status) {
        rasterveld[koppel.getxPositie()][koppel.getyPositie()] = status;
    }

}
