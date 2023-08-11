
public class NBody {

    /**
     * Read radius from the file.
     */
    public static double readRadius(String filename) {
        In in = new In(filename);

        int num = in.readInt();
        double radius = in.readDouble();

        return radius;
    }

    /**
     * Read Planets from the file.
     */
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);

        int num = in.readInt();
        double radius = in.readDouble();

        Planet[] p = new Planet[num];

        for (int i = 0; i < num; i++) {
            double xP = in.readDouble(); 
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            p[i] = new Planet(xP, yP, xV, yV, m, img);
        }

        return p;
    }
}