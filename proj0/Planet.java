public class Planet {

    public static double gravitationalConstant = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) 
            + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        return gravitationalConstant * this.mass * p.mass 
            / (this.calcDistance(p) * this.calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos)
            / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos)
            / this.calcDistance(p);
    }

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

    public void update(double dt, double fX, double fY) {
        this.xxVel += fX / this.mass * dt;
        this.yyVel += fY / this.mass * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }
}