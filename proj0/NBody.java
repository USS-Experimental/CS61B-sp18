/**
 * The main method of the NBody project.
 */
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

        /**
         * Get the info from the StdIO.
         */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        String imageToDraw = "images/starfield.jpg";

        /**
         * Get the info of Planets from the designated file.
         */
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        /**
         * Set the radius of the background.
         */
        StdDraw.setScale(-radius, radius);

        /**
         * Print the background.
         */
        StdDraw.picture(0, 0, imageToDraw);

        for (int i = 0; i < planets.length; i++) {
            StdDraw.picture(planets[i].xxPos, planets[i].yyPos, "images/" + planets[i].imgFileName);
        }

        StdDraw.enableDoubleBuffering();

        /**
         * Run the program until t reach T.
         */
        for (double t = 0; t != T; t += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            /**
             * Store the changes of the Planets.
             */
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            /**
             * Update the data of the Planets.
             */
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            /**
             * Redraw the background.
             */
            StdDraw.picture(0, 0, imageToDraw);
            
            /**
             * Draw the updated Planets.
             */
            for (int i = 0; i < planets.length; i++) {
                StdDraw.picture(planets[i].xxPos, planets[i].yyPos, 
                    "images/" + planets[i].imgFileName);
            }

            /**
             * Display the background and the updated Planets.
             */
            StdDraw.show();

            /**
             * Pause for 10 milliseconds.
             */
            StdDraw.pause(10);
        }

        /**
         * Print the info of Planets after running the program.
         */
        StdOut.printf("%d\n", planets.length);

        StdOut.printf("%.2e\n", radius);

        for (int i = 0; i < planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                       planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                       planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}