package Lambda_Expressions;

interface LightBehavior {
    void activate();
}

public class SmartHomeLighting {
    public static void main(String[] args) {
        
        LightBehavior motionDetected = () -> 
            System.out.println("Motion detected → Turning on bright white lights.");
        
        LightBehavior eveningMode = () -> 
            System.out.println("Evening mode → Setting warm yellow dim lights.");
        
        LightBehavior voiceCommand = () -> 
            System.out.println("Voice command → Activating party mode with color cycling.");

        triggerLight(motionDetected);  // Motion sensor trigger
        triggerLight(eveningMode);     // Time-based trigger
        triggerLight(voiceCommand);    // Voice-based trigger
    }

    // Method to trigger any light behavior
    static void triggerLight(LightBehavior behavior) {
        behavior.activate();
    }
}
