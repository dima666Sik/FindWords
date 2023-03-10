# _Find Words_ 🔎📃
![shield stars](https://img.shields.io/github/stars/dima666Sik/FindWords?color=orange&label=Stars&style=plastic)
![languages in repo](https://img.shields.io/github/languages/top/dima666Sik/FindWords?style=flat-square)
![pull requests](https://img.shields.io/github/issues-pr/dima666Sik/FindWords?style=plastic)
![Forks](https://img.shields.io/github/forks/dima666Sik/FindWords?style=social)

## Preview 
1. This project uses jdk 11, Swing;
2. Project consists of 2 levels such as: ui, domain;
3. Project uses `Swing` interface;
4. System can be extended;
5. For testing the system uses `JUnit5`;
6. Using FreeTTS VoiceManager, i.e. turn selected text into speech.

## About
In this project, a search for a word in the text was implemented. All found words are highlighted in blue. The project can be to add features in a future. In the project, at the moment, search is implemented only for JTextArea.
User can select part text, select voice and start reading selected part text.

## Launch guide
To run this project you will need to install JDK 11 or higher.
Here are the steps for you to follow:
- Add this project to your IDE as Maven project;
- If necessary, configure Java SDK 11 in Project Structure settings;
- This project will be searching word in strings that have in the end this symbols: ., ?, !. (, - this symbol does not count).
- If you want to hear select part text, please select part or all text, select voice and start reading clicked on button `'Start Reading'`. 

## Features
☑️Search for the number of words in a text;
<br>☑️Search for a word in a text;
<br>☑️The ability to add text to the application.
<br>☑️Text to speech.

## Testing Program
### _Main Menu_
![Main Menu](src/main/resources/img/main_menu.png)
### _Result find words in JTextArea in Swing_
![Result](src/main/resources/img/result_find_word_swing.png)
### _Select and start text to speech_
![Selected part text](src/main/resources/img/demonstrate_selected_text_to_speech.png)
![Text to speech](src/main/resources/img/start_text_to_speech.png)
