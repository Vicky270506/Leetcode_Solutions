class Solution {
    public double angleClock(int hour, int minutes) {
        double hangle = 30 * hour + minutes * 0.5;
        double mangle =  minutes * 6;
        double d = Math.abs(hangle - mangle);
        return Math.min(d, Math.abs(360-d));
    }
}