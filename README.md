# My Dice  
  
My Dice is a dice rolling application.  
In this application, the user has to enter dice numbers between 1 to 6 which they want to roll.  
The application has features of rolling dices through button click or shaking their devices.  

### Technical Specifications  

Android Studio API level - 23  
Internet connection is not required for using this application  
Only runs on android devices

### Installation
This application does not use any external libraries so, for installation user has to just install APK file of *My Dice* app.
  
### Functionalities 

This application uses simple random function to interchange the images while user presses the button or shake his device. Thus, the function of rolling dices is executed.

For shake detection code uses accelerometer. So, when user shakes device after entering the dice numbers, they are rolled. The shaking sensitivity depends upon the sensitivity number which is "2" given in the code. The code also includes comments so, developers can easily understand the entire code and can modify this sensitivity number and other elements.

It looks simple application because of simple UI, however the combination of simple and sober colors make it reach. Along with these functionalities, the sound effects are also added which gives proper experience of dice rolling to user when he presses the button or shakes his device.

Moreover, it is easy to install and the lables are information reach which guides novice users in a accurate way. If users enters
the number which is not between 1 to 6 including 1 and 6 then he will get a toast message for entering the number in limit of 1 to 6.
  
### Bugs
1)This application uses sound effect during button pressing and shaking the device. So, when user leaves the application witout     killing it then sound will apppear while phone is shaked because the app would be running in background. So, after using this     application user will have to kill application.
  I tried to solve this issue but this is dependent upon Android life-cycle which requires more research. 

2)The sound effect works perfectly during shaking the phone.
  But during button press instead of appeaaring in each press, sound appears in alternate pattern.

3)For different devices sensetivity differs so, some device would be more sensitive then others. 

In next version, I will solve these both issues.

### Important Elements(java files and XML)  

#### Dice_Rolling.java  

My Dice has only this one activity where all logic has been implemented.  
dice_value() - this method is used for random number generation  
onSensorChanged(SensorEvent event) - this method handles all logic related to dice roll through shaking feature  
  

#### activity_dice_rolling.xml  

This file is layout file which is an interface of My Dice which includes edit text, text view, and button elements  
  

#### drawable  

this folder consists of 6 sided dice images  
  

#### values  

This folder consists of two main files as below  
1)colors.xml  

  this file contains colors used in this application such as button color and color for the navigation bar  

2)strings.xml  

  consists application name as string  
  

### raw  

this folder consists of sound effect for dice rolling  
  

### References
[1]"Learn to create a Roll Dice game with Android Studio", _YouTube_, 2019. [Online]. Available: https://www.youtube.com/watch?v=06xnzRmAnuU. [Accessed: 16- Jun- 2019].
[2]"Learn to create a Roll Dice Game on Android", _Medium_, 2019. [Online]. Available: https://medium.com/@ssaurel/learn-to-create-a-roll-dice-game-on-android-a612167361cf. [Accessed: 16- Jun- 2019].
[3]"Category:Dice faces - Wikimedia Commons", _Commons.wikimedia.org_, 2019. [Online]. Available: https://commons.wikimedia.org/wiki/Category:Dice_faces#/media/File:Alea_6.png. [Accessed: 16- Jun- 2019].
[4]"Android studio 3.3 tutorial - Android *** Shake Listener *** example. Android app 2019 tutorial.", _YouTube_, 2019. [Online]. Available: https://www.youtube.com/watch?v=D-qfVHvNQ8M. [Accessed: 16- Jun- 2019].
[5]"dice rolling images - Google Search", _Google.com_, 2019. [Online]. Available: https://www.google.com/search?q=dice+rolling+images&rlz=1C1CHBF_enCA845CA848&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjE-_y2j-TiAhVmUN8KHdN0DZoQ_AUIECgB&biw=1536&bih=674#imgrc=8g1OEILPUAdv1M:. [Accessed: 16- Jun- 2019].
[6]"Android studio Basic Concepts | Tutorial #2 | Button On Click Sound", _YouTube_, 2019. [Online]. Available: https://www.youtube.com/watch?v=G3CAvUn1AlI&t=518s. [Accessed: 16- Jun- 2019].