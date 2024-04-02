public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;
    private boolean manha;
    
    public ClockDisplay()
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {
            hours.increment();
            if(hours.getValue() == 0) {
                manha = true;
            } else if(hours.getValue() == 12) {
                manha = false;
            }
        }
        updateDisplay();
    }

    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        if(hour < 12) {
            manha = true;    
        } else {
            manha = false;
        }
        updateDisplay();
    }

    public String getTime()
    {
        return displayString;
    }
    
    private void updateDisplay()
    {
        displayString = (manha ? "AM" : "PM") + " " + hours.getDisplayValue() + ":" + minutes.getDisplayValue();
    }
}
