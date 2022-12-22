package logic.speech;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {
    public static void textToSpeech(String nameVoice, String partText) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        // VoiceManager uses the singleton approach to creating and
        // providing an instance
        VoiceManager vm = VoiceManager.getInstance();
        Voice voice = vm.getVoice(nameVoice);
        voice.allocate();
        voice.speak(partText);
        voice.deallocate();
    }
}
