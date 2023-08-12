
/**
 *  Definition of Planet Class and its methods.
 */
public class Planet {

    /**
     * Define the gravitational constant.
     */
    public static double gravitationalConstant = 6.67e-11;

    /**
     * The current x position of the Planet.
     */
    public double xxPos;

    /**
     * The current y position of the Planet.
     */
    public double yyPos;

    /**
     * The current velocity in the x direction of the Planet.
     */
    public double xxVel;

    /**
     * The current velocity in the y direction of the Planet.
     */
    public double yyVel;

    /**
     * The mass of the Planet.
     */
    public double mass;

    /**
     * The name of the file that corresponds to the image that depicts the Planet.
     */
    public String imgFileName;

    /**
     * The constructor of the Planet class.
     */
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
                
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**
     * Another constructor of the Planet class, take in a Planet object.
     */
    public Planet(Planet p) {

        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /**
     * Calculates the distance between two Planets.
     */
    public double calcDistance(Planet p) {

        return Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) 
            + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
    }

    /**
     * Calculates the force between two Planets.
     */
    public double calcForceExertedBy(Planet p) {

        return gravitationalConstant * this.mass * p.mass 
            / (this.calcDistance(p) * this.calcDistance(p));
    }

    /**
     * Calculates the force in the x direction between two Planets.
     */
    public double calcForceExertedByX(Planet p) {

        return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos)
            / this.calcDistance(p);
    }

    /**
     * Calculates the force in the y direction between two Planets.
     */
    public double calcForceExertedByY(Planet p) {

        return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos)
            / this.calcDistance(p);
    }

    /**
     * Calculates the total force in the x direction of a Planet.
     */
    public double calcNetForceExertedByX(Planet[] p) {

        double sum = 0;
        for (Planet s : p) {
            if (this.equals(s)) {
                continue;
            }
            sum += this.calcForceExertedByX(s);
        }
        return sum;
    }

    /**
     * Calculates the total force in the y direction of a Planet.
     */
    public double calcNetForceExertedByY(Planet[] p) {

        double sum = 0;
        for (Planet s : p) {
            if (this.equals(s)) {
                continue;
            }
            sum += this.calcForceExertedByY(s);
        }
        return sum;
    }

    /**
     * Update the status of a Planet.
     */
    public void update(double dt, double fX, double fY) {

        this.xxVel += fX / this.mass * dt;
        this.yyVel += fY / this.mass * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    /**
     * Draw a Planet
     */
    public void draw() {

        StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
    }
}