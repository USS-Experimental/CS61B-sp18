
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

    public static void main(String[] args) {

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        String imageToDraw = "images/starfield.jpg";

        StdDraw.setScale(-radius, radius);

        StdDraw.picture(0, 0, imageToDraw);

        for (int i = 0; i < planets.length; i++) {
            StdDraw.picture(planets[i].xxPos, planets[i].yyPos, "images/" + planets[i].imgFileName);
        }

        StdDraw.enableDoubleBuffering();

        for (double t = 0; t != T; t += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, imageToDraw);

            for (int i = 0; i < planets.length; i++) {
            StdDraw.picture(planets[i].xxPos, planets[i].yyPos, "images/" + planets[i].imgFileName);
            }

            StdDraw.show();

            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", planets.length);

        StdOut.printf("%.2e\n", radius);

        for (int i = 0; i < planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                       planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                       planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}