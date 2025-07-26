/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pwerpuff_girls_pnm;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SpotLight;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Cylinder;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


public class PwerPuff_Girls_PNM extends Application {
     private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        StartScene(); // عرض صفحة البداية عند بدء التطبيق
    }

    private void StartScene() {
        StackPane layout = new StackPane();

        // Setting up the background
        Image background = new Image(getClass().getResourceAsStream("/img/powerpuff.jpg"));
        ImageView backgroundImage = new ImageView(background);
        backgroundImage.setFitWidth(WIDTH);
        backgroundImage.setFitHeight(HEIGHT);

        Text begingtext = new Text("Information Challenge");
        begingtext.setFont(Font.font("Showcard Gothic",70));
        begingtext.setTranslateY(-240);
        begingtext.setFill(Color.rgb(239,21,100));
    
        Text begingtext2 = new Text("Let's see , do you remember us?");
        begingtext2.setFont(Font.font("Showcard Gothic",40));
        begingtext2.setTranslateY(-190);
        begingtext2.setFill(Color.rgb(244,238,0));


        // Start button to go to the questions
        Image startImage = new Image(getClass().getResourceAsStream("/img/start.png"));
        ImageView startImageView = new ImageView(startImage);
        startImageView.setFitWidth(160); 
        startImageView.setFitHeight(90); 
        startImageView.setTranslateY(200);

        
        startImageView.setOnMouseClicked((MouseEvent e) -> {
            QuestionScene1(); // Transition to the questions page
        });

        layout.getChildren().addAll(backgroundImage, begingtext,begingtext2, startImageView);

        Scene startScene = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setTitle("PowerPuff Girls");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    private void QuestionScene1() {
        StackPane layout = new StackPane();

       // Setting up the background
        Image background = new Image(getClass().getResourceAsStream("/img/Q1.jpg"));
        ImageView backgroundImage = new ImageView(background);
        backgroundImage.setFitWidth(WIDTH);
        backgroundImage.setFitHeight(HEIGHT);

        // Question text
        Text Question1 = new Text("Who is the teacher?");
        Question1.setFont(Font.font("Showcard Gothic",50));
        Question1.setTranslateY(-215);

        // Answer options
        ToggleGroup answersGroup = new ToggleGroup();
        RadioButton answer1 = new RadioButton();
        answer1.setToggleGroup(answersGroup);
        answer1.setTranslateX(-390);
        answer1.setTranslateY(-120);
        
        RadioButton answer2 = new RadioButton();
        answer2.setToggleGroup(answersGroup);
        answer2.setTranslateX(50);
        answer2.setTranslateY(-120);
        
        RadioButton answer3 = new RadioButton();
        answer3.setToggleGroup(answersGroup);
        answer3.setTranslateX(-390);
        answer3.setTranslateY(100);
        
        RadioButton answer4 = new RadioButton();
        answer4.setToggleGroup(answersGroup);
        answer4.setTranslateX(50);
        answer4.setTranslateY(100);
        
        // Transition
        Image startImage = new Image(getClass().getResourceAsStream("/img/next.png"));
        ImageView nextImageView = new ImageView(startImage);
        nextImageView.setFitWidth(90); 
        nextImageView.setFitHeight(50); 
        nextImageView.setTranslateY(270);
        nextImageView.setTranslateX(450);
        
        // Adding click event to the image
        nextImageView.setOnMouseClicked((MouseEvent e) -> {
            if (answersGroup.getSelectedToggle() == answer4) {
                QuestionScene2(); 
            } else {
                System.out.println("try again");
            }
        });
        
        // Adding elements to the layout
        layout.getChildren().addAll(backgroundImage, Question1,answer1,answer2,
                answer3,answer4, nextImageView);
      
        Scene questionScene1 = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setTitle("Question 1");
        primaryStage.setScene(questionScene1);
        primaryStage.show();
    }
    
    //next questions - The same logic
    private void QuestionScene2() {
        StackPane layout = new StackPane();

      
        Image background = new Image(getClass().getResourceAsStream("/img/Q2.jpg"));
        ImageView backgroundImage = new ImageView(background);
        backgroundImage.setFitWidth(WIDTH);
        backgroundImage.setFitHeight(HEIGHT);

       
        Text Question1 = new Text("Who is the mad scientist?");
        Question1.setFont(Font.font("Showcard Gothic",50));
        Question1.setTranslateY(-215);

        
        ToggleGroup answersGroup = new ToggleGroup();
        RadioButton answer1 = new RadioButton();
        answer1.setToggleGroup(answersGroup);
        answer1.setTranslateX(-390);
        answer1.setTranslateY(-120);
        
        RadioButton answer2 = new RadioButton();
        answer2.setToggleGroup(answersGroup);
        answer2.setTranslateX(50);
        answer2.setTranslateY(-120);
        
        RadioButton answer3 = new RadioButton();
        answer3.setToggleGroup(answersGroup);
        answer3.setTranslateX(-390);
        answer3.setTranslateY(100);
        
        RadioButton answer4 = new RadioButton();
        answer4.setToggleGroup(answersGroup);
        answer4.setTranslateX(50);
        answer4.setTranslateY(100);
        
        
        Image startImage = new Image(getClass().getResourceAsStream("/img/next.png"));
        ImageView nextImageView = new ImageView(startImage);
        nextImageView.setFitWidth(90); 
        nextImageView.setFitHeight(50); 
        nextImageView.setTranslateY(270);
        nextImageView.setTranslateX(450);
        
        
        nextImageView.setOnMouseClicked((MouseEvent e) -> {
            if (answersGroup.getSelectedToggle() == answer2) {
                QuestionScene3(); 
            } else {
                System.out.println("try again");
            }
        });
        
        
        layout.getChildren().addAll(backgroundImage, Question1,answer1,answer2,
                answer3,answer4, nextImageView);
      
        Scene questionScene1 = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setTitle("Question 2");
        primaryStage.setScene(questionScene1);
        primaryStage.show();
    }
    //next questions - The same logic
       private void QuestionScene3() {
        StackPane layout = new StackPane();

        
        Image background = new Image(getClass().getResourceAsStream("/img/Q3.jpg"));
        ImageView backgroundImage = new ImageView(background);
        backgroundImage.setFitWidth(WIDTH);
        backgroundImage.setFitHeight(HEIGHT);

       
        Text Question1 = new Text("Who is the spoiled rich girl?");
        Question1.setFont(Font.font("Showcard Gothic",40));
        Question1.setTranslateY(-215);

       
        ToggleGroup answersGroup = new ToggleGroup();
        RadioButton answer1 = new RadioButton();
        answer1.setToggleGroup(answersGroup);
        answer1.setTranslateX(-390);
        answer1.setTranslateY(-120);
        
        RadioButton answer2 = new RadioButton();
        answer2.setToggleGroup(answersGroup);
        answer2.setTranslateX(50);
        answer2.setTranslateY(-120);
        
        RadioButton answer3 = new RadioButton();
        answer3.setToggleGroup(answersGroup);
        answer3.setTranslateX(-390);
        answer3.setTranslateY(100);
        
        RadioButton answer4 = new RadioButton();
        answer4.setToggleGroup(answersGroup);
        answer4.setTranslateX(50);
        answer4.setTranslateY(100);
        
        
        Image startImage = new Image(getClass().getResourceAsStream("/img/next.png"));
        ImageView nextImageView = new ImageView(startImage);
        nextImageView.setFitWidth(90); 
        nextImageView.setFitHeight(50); 
        nextImageView.setTranslateY(270);
        nextImageView.setTranslateX(450);
        
        
        nextImageView.setOnMouseClicked((MouseEvent e) -> {
            if (answersGroup.getSelectedToggle() == answer3) {
                QuestionScene4(); 
            } else {
                System.out.println("try again");
            }
        });
        
       
        layout.getChildren().addAll(backgroundImage, Question1,answer1,answer2,
                answer3,answer4, nextImageView);
      
        Scene questionScene1 = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setTitle("Question 3");
        primaryStage.setScene(questionScene1);
        primaryStage.show();
    }
    //next questions - The same logic
           private void QuestionScene4() {
        StackPane layout = new StackPane();

      
        Image background = new Image(getClass().getResourceAsStream("/img/Q4.jpg"));
        ImageView backgroundImage = new ImageView(background);
        backgroundImage.setFitWidth(WIDTH);
        backgroundImage.setFitHeight(HEIGHT);

       
        Text Question1 = new Text("Who is the leader?");
        Question1.setFont(Font.font("Showcard Gothic",50));
        Question1.setTranslateY(-215);

        
        ToggleGroup answersGroup = new ToggleGroup();
        RadioButton answer1 = new RadioButton();
        answer1.setToggleGroup(answersGroup);
        answer1.setTranslateX(-390);
        answer1.setTranslateY(-120);
        
        RadioButton answer2 = new RadioButton();
        answer2.setToggleGroup(answersGroup);
        answer2.setTranslateX(50);
        answer2.setTranslateY(-120);
        
        RadioButton answer3 = new RadioButton();
        answer3.setToggleGroup(answersGroup);
        answer3.setTranslateX(-390);
        answer3.setTranslateY(100);
        
        RadioButton answer4 = new RadioButton();
        answer4.setToggleGroup(answersGroup);
        answer4.setTranslateX(50);
        answer4.setTranslateY(100);
        
       
        Image startImage = new Image(getClass().getResourceAsStream("/img/next.png"));
        ImageView nextImageView = new ImageView(startImage);
        nextImageView.setFitWidth(90); 
        nextImageView.setFitHeight(50); 
        nextImageView.setTranslateY(270);
        nextImageView.setTranslateX(450);
        
        
        nextImageView.setOnMouseClicked((MouseEvent e) -> {
            if (answersGroup.getSelectedToggle() == answer1) {
                QuestionScene5(); 
            } else {
                System.out.println("try again");
            }
        });
        
        
        layout.getChildren().addAll(backgroundImage, Question1,answer1,answer2,
                answer3,answer4, nextImageView);
      
        Scene questionScene1 = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setTitle("Question 4");
        primaryStage.setScene(questionScene1);
        primaryStage.show();
    }
     
           //next questions - The same logic
        private void QuestionScene5() {
        StackPane layout = new StackPane();

      
        Image background = new Image(getClass().getResourceAsStream("/img/Q5.jpg"));
        ImageView backgroundImage = new ImageView(background);
        backgroundImage.setFitWidth(WIDTH);
        backgroundImage.setFitHeight(HEIGHT);

        
        Text Question1 = new Text("Where is the evil gang?");
        Question1.setFont(Font.font("Showcard Gothic",50));
        Question1.setTranslateY(-215);

        
        ToggleGroup answersGroup = new ToggleGroup();
        RadioButton answer1 = new RadioButton();
        answer1.setToggleGroup(answersGroup);
        answer1.setTranslateX(-390);
        answer1.setTranslateY(-120);
        
        RadioButton answer2 = new RadioButton();
        answer2.setToggleGroup(answersGroup);
        answer2.setTranslateX(50);
        answer2.setTranslateY(-120);
        
        RadioButton answer3 = new RadioButton();
        answer3.setToggleGroup(answersGroup);
        answer3.setTranslateX(-390);
        answer3.setTranslateY(100);
        
        RadioButton answer4 = new RadioButton();
        answer4.setToggleGroup(answersGroup);
        answer4.setTranslateX(50);
        answer4.setTranslateY(100);
        
       
        Image startImage = new Image(getClass().getResourceAsStream("/img/next.png"));
        ImageView nextImageView = new ImageView(startImage);
        nextImageView.setFitWidth(90); 
        nextImageView.setFitHeight(50); 
        nextImageView.setTranslateY(270);
        nextImageView.setTranslateX(450);
        
       
        nextImageView.setOnMouseClicked((MouseEvent e) -> {
            if (answersGroup.getSelectedToggle() == answer4) {
                QuestionScene6(); 
            } else {
                System.out.println("try again");
            }
        });
        
      
        layout.getChildren().addAll(backgroundImage, Question1,answer1,answer2,
                answer3,answer4, nextImageView);
      
        Scene questionScene1 = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setTitle("Question 5");
        primaryStage.setScene(questionScene1);
        primaryStage.show();
    }
        
        //next questions - The same logic
        private void QuestionScene6() {
        StackPane layout = new StackPane();

      
        Image background = new Image(getClass().getResourceAsStream("/img/Q6.jpg"));
        ImageView backgroundImage = new ImageView(background);
        backgroundImage.setFitWidth(WIDTH);
        backgroundImage.setFitHeight(HEIGHT);

     
        Text Question1 = new Text("Who doesn't have a superpower?");
        Question1.setFont(Font.font("Showcard Gothic",40));
        Question1.setTranslateY(-215);

        
        ToggleGroup answersGroup = new ToggleGroup();
        RadioButton answer1 = new RadioButton();
        answer1.setToggleGroup(answersGroup);
        answer1.setTranslateX(-390);
        answer1.setTranslateY(-120);
        
        RadioButton answer2 = new RadioButton();
        answer2.setToggleGroup(answersGroup);
        answer2.setTranslateX(50);
        answer2.setTranslateY(-120);
        
        RadioButton answer3 = new RadioButton();
        answer3.setToggleGroup(answersGroup);
        answer3.setTranslateX(-390);
        answer3.setTranslateY(100);
        
        RadioButton answer4 = new RadioButton();
        answer4.setToggleGroup(answersGroup);
        answer4.setTranslateX(50);
        answer4.setTranslateY(100);
        
        
        Image startImage = new Image(getClass().getResourceAsStream("/img/next.png"));
        ImageView nextImageView = new ImageView(startImage);
        nextImageView.setFitWidth(90); 
        nextImageView.setFitHeight(50); 
        nextImageView.setTranslateY(270);
        nextImageView.setTranslateX(450);
        
       
        nextImageView.setOnMouseClicked((MouseEvent e) -> {
            if (answersGroup.getSelectedToggle() == answer2) {
                Celebration(); 
            } else {
                System.out.println("try again");
            }
        });
        
        
        layout.getChildren().addAll(backgroundImage, Question1,answer1,answer2,
                answer3,answer4, nextImageView);
      
        Scene questionScene1 = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setTitle("Question 6");
        primaryStage.setScene(questionScene1);
        primaryStage.show();
    }
    // display the celebration screen
      private void Celebration() {
        StackPane layout = new StackPane();

        // Setting up the background image
        Image background = new Image(getClass().getResourceAsStream("/img/Celebration.jpg"));
        ImageView backgroundImage = new ImageView(background);
        backgroundImage.setFitWidth(WIDTH);
        backgroundImage.setFitHeight(HEIGHT);
        
        // Display congratulatory message
        Text Celebtext = new Text("Good Job Girls");
        Celebtext.setFont(Font.font("Showcard Gothic",70));
        Celebtext.setTranslateY(-250);
        Celebtext.setFill(Color.rgb(239,21,100));
    
        // Set start button image
        Text Celebtext2 = new Text("Now we will move to the game"
                        + "\n                      are you ready?");
        Celebtext2.setFont(Font.font("Showcard Gothic",40));
        Celebtext2.setTranslateY(-180);
        Celebtext2.setFill(Color.rgb(215,190,3));


      
        Image startImage = new Image(getClass().getResourceAsStream("/img/start.png"));
        ImageView startImageView = new ImageView(startImage);
        startImageView.setFitWidth(160); 
        startImageView.setFitHeight(90); 
        startImageView.setTranslateY(200);

         // Handle click event to move to the character selection scene
        startImageView.setOnMouseClicked((MouseEvent e) -> {
            showCharacterSelection(); 
        });

        layout.getChildren().addAll(backgroundImage, Celebtext,Celebtext2, startImageView);

        Scene startScene = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setTitle("PowerPuff Girls");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

// display the character selection screen
    private void showCharacterSelection() {
        
        Image background = new Image(getClass().getResourceAsStream("/img/Select.png"));
        ImageView backgroundImage = new ImageView(background);
        backgroundImage.setFitWidth(WIDTH);
        backgroundImage.setFitHeight(HEIGHT);
        
        Text Charactertext = new Text("Choose the character");
        Charactertext.setFont(Font.font("Showcard Gothic",70));
        Charactertext.setTranslateY(-250);
        Charactertext.setFill(Color.rgb(239,21,100));
    
        Text Charactertext2 = new Text("What is your favorite character?");
        Charactertext2.setFont(Font.font("Showcard Gothic",40));
        Charactertext2.setTranslateY(-180);
        Charactertext2.setFill(Color.rgb(215,190,3));
        
        // Create layout for character selection
        StackPane layout = new StackPane();
        layout.getChildren().add(backgroundImage);

         layout.getChildren().add(Charactertext);
         layout.getChildren().add(Charactertext2);
        // add character
        layout.getChildren().add(createCharacterSelection("Blossom", 
                "/img/blossomS.png", -5, 60));
        
        layout.getChildren().add(createCharacterSelection("Bubbles", 
                "/img/bubblesS.png", -256, 60));
        
        layout.getChildren().add(createCharacterSelection("Buttercup", 
                "/img/buttecupS.png", 256, 60));
        
      

        Scene selectionScene = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setTitle("Character Selection");
        primaryStage.setScene(selectionScene);
        primaryStage.show();
    }

    // create a character selection button
  private StackPane createCharacterSelection(String characterName, String imagePath, double translateX, double translateY) {
    StackPane stackPane = new StackPane();

    
    Image characterImage = new Image(imagePath);
    ImageView imageView = new ImageView(characterImage);
    imageView.setFitWidth(100);
    imageView.setFitHeight(100);

    // Set click event to choose character and start the game
    imageView.setOnMouseClicked(e -> showGameScene(characterName));

    // Positioning the character selection button
    stackPane.setTranslateX(translateX);
    stackPane.setTranslateY(translateY);

    // Add image to the layout
    stackPane.getChildren().add(imageView);
    
    return stackPane;
}
    
private void showGameScene(String character) {
    // Setting up the background image
    Image backgroundImage = new Image(getClass().getResourceAsStream("/img/Backgraound2.png"));
    ImageView backgroundImageView1 = new ImageView(backgroundImage);
    backgroundImageView1.setFitWidth(WIDTH);
    backgroundImageView1.setFitHeight(HEIGHT);
  
    // Setting up the main character as a  box with the texture
    Box characterBox = new Box(90, 90, 0);
    Image characterImage = null;
    
 // Load character-specific texture
    switch (character) {
        case "Blossom":
            characterImage = new Image("/img/blossomS.png");
            break;
        case "Bubbles":
            characterImage = new Image("/img/bubblesS.png");
            break;
        case "Buttercup":
            characterImage = new Image("/img/buttecupS.png");
            break;
      
    }

    PhongMaterial material = new PhongMaterial();
    material.setDiffuseMap(characterImage);
    characterBox.setMaterial(material);
    // Set character position
    characterBox.setTranslateX(100); 
    characterBox.setTranslateY(300);

       //------------------------------sun-------------------------
        
        // Create and position the sun
    Image sunnImage = new Image("/img/sun.png"); 
    ImageView sun = new ImageView(sunnImage);
    // sets the width and height of the sun image 
    sun.setFitWidth(100); 
    sun.setFitHeight(100);
    sun.setTranslateY(60); // Set character position
    sun.setTranslateX(90); 
    sun.setTranslateZ(-70);// Set depth position
    
      PointLight sunnLight = new PointLight(Color.rgb(255, 255, 224)); // Light color
      //Positions the light source to follow the sun's X position and places it 100 units back on the Z-axis.
    sunnLight.setTranslateX(sun.getTranslateX());
    //sunnLight.setTranslateY(sun.getTranslateY() + 1);
    sunnLight.setTranslateZ(-100); 

   
    // Add animation to make the sun move horizontally back and forth
    TranslateTransition sunnTransition = new TranslateTransition(Duration.seconds(50), sun);
    // Start position on the X axis and End position on the X axis
    sunnTransition.setFromX(0); 
    sunnTransition.setToX(WIDTH); 
    sunnTransition.setCycleCount(TranslateTransition.INDEFINITE);// Loop the transition indefinitely
    sunnTransition.setInterpolator(Interpolator.LINEAR);
    sunnTransition.setAutoReverse(true); 
    sunnTransition.play();// Start the animation
  
     // Synchronize the light's position with the sun during the animation
     Timeline lightFollowTimeline = new Timeline(
            new KeyFrame(
                Duration.millis(10), 
                event -> {
                    sunnLight.setTranslateX(sun.getTranslateX());
                    sunnLight.setTranslateY(sun.getTranslateY());
                }
            )
        );
        lightFollowTimeline.setCycleCount(Timeline.INDEFINITE);// Loop the light update indefinitely
        lightFollowTimeline.play();

    
//---------------------------cloud-------------------------------------------
     // Create and position multiple clouds
        Image cloudImage = new Image("/img/cloud.png");

        // Create multiple cloud images  
        ImageView cloud1 = new ImageView(cloudImage);
        ImageView cloud2 = new ImageView(cloudImage);
        ImageView cloud3 = new ImageView(cloudImage);
        ImageView cloud4 = new ImageView(cloudImage);
        ImageView cloud5 = new ImageView(cloudImage);

        // Set cloud sizes
        cloud1.setFitWidth(140);
        cloud1.setFitHeight(140);
        cloud2.setFitWidth(110);
        cloud2.setFitHeight(110);
        cloud3.setFitWidth(140);
        cloud3.setFitHeight(140);
        cloud4.setFitWidth(120);
        cloud4.setFitHeight(120);
        cloud5.setFitWidth(140);
        cloud5.setFitHeight(140);

        // Set cloud positions
        cloud1.setTranslateY(90);
        cloud1.setTranslateX(90);
        cloud1.setTranslateZ(-80);
        
        cloud2.setTranslateY(100);
        cloud2.setTranslateX(280);
        cloud2.setTranslateZ(-80);
        
        cloud3.setTranslateY(70);
        cloud3.setTranslateX(540);
        cloud3.setTranslateZ(-80);
          
        cloud4.setTranslateY(-10);
        cloud4.setTranslateX(700);
        cloud4.setTranslateZ(-80);
  
        cloud5.setTranslateY(40);
        cloud5.setTranslateX(-10);
        cloud5.setTranslateZ(-80);
        
        // Call method to make clouds move
        createCloudMovement(cloud1);
        createCloudMovement(cloud2);
        createCloudMovement(cloud3);
        createCloudMovement(cloud4);
        createCloudMovement(cloud5);
//------------------------------------Door setup-----------------------------
     // Create and position doors using Box shapes with  textures
    Image doorImage = new Image("/img/door.jpg");

         PhongMaterial doorMaterial = new PhongMaterial();
        doorMaterial.setDiffuseMap(doorImage);

       
        Box door1 = new Box(30, 200, 1); 
        Box door2 = new Box(30, 200, 1);
        Box doorLeft = new Box(30, 200, 1);

        // Apply material
        door1.setMaterial(doorMaterial);
        door2.setMaterial(doorMaterial);
        doorLeft.setMaterial(doorMaterial);
        // Rotate
        door1.setRotate(90); 
        door2.setRotate(90);
        doorLeft.setRotate(90);
        
       // Set door positions
       door1.setTranslateX(900);
        door1.setTranslateY(300);
        door1.setTranslateZ(-80); 

        door2.setTranslateX(900);
        door2.setTranslateY(500);
        door2.setTranslateZ(-80); 

        
        doorLeft.setTranslateX(100);
        doorLeft.setTranslateY(350);
        doorLeft.setTranslateZ(-80); 
        

//----------------------------------monster-------------------------------------------

    // Create monsters at specific positions
    Box monster1 = createMonster(WIDTH - 50, 250);
    Box monster2 = createMonster(WIDTH - 50, 450);
    
      //-----------------------------------GIRLS rotate--------------------------------------
Image cubebuttImage = new Image("/img/t1.png");
Image cubebubbImage = new Image("/img/t2.png");
Image cubebloImage = new Image("/img/t3.png");

// Create cubes using Box
Box cube1 = new Box(50, 50, 50);
Box cube2 = new Box(50, 50, 50);
Box cube3 = new Box(50, 50, 50);

// Apply textures to the cubes
PhongMaterial material1 = new PhongMaterial();
material1.setDiffuseMap(cubebuttImage);

PhongMaterial material2 = new PhongMaterial();
material2.setDiffuseMap(cubebubbImage);

PhongMaterial material3 = new PhongMaterial();
material3.setDiffuseMap(cubebloImage);

cube1.setMaterial(material1);
cube2.setMaterial(material2);
cube3.setMaterial(material3);

// Set positions for the cubes at the bottom of the screen
cube1.setTranslateX(90);
cube1.setTranslateY(HEIGHT - 50);
cube1.setTranslateZ(0);

cube2.setTranslateX(190);
cube2.setTranslateY(HEIGHT - 50);
cube2.setTranslateZ(0);

cube3.setTranslateX(290);
cube3.setTranslateY(HEIGHT - 50);
cube3.setTranslateZ(0);


// Add rotation animation on the Y-axis for each cube
RotateTransition rotateCUBE1 = new RotateTransition(Duration.seconds(5), cube1);
rotateCUBE1.setByAngle(360);
rotateCUBE1.setAxis(Rotate.Y_AXIS);
rotateCUBE1.setCycleCount(RotateTransition.INDEFINITE);
rotateCUBE1.setInterpolator(Interpolator.LINEAR);
rotateCUBE1.play();

RotateTransition rotateCUBE2 = new RotateTransition(Duration.seconds(5), cube2);
rotateCUBE2.setByAngle(360);
rotateCUBE2.setAxis(Rotate.Y_AXIS);
rotateCUBE2.setCycleCount(RotateTransition.INDEFINITE);
rotateCUBE2.setInterpolator(Interpolator.LINEAR);
rotateCUBE2.play();

RotateTransition rotateCUBE3 = new RotateTransition(Duration.seconds(5), cube3);
rotateCUBE3.setByAngle(360);
rotateCUBE3.setAxis(Rotate.Y_AXIS);
rotateCUBE3.setCycleCount(RotateTransition.INDEFINITE);
rotateCUBE3.setInterpolator(Interpolator.LINEAR);
rotateCUBE3.play();

//-------------------------------ambientLight--------------------------

    //ambientLight
    AmbientLight ambientLight = new AmbientLight(Color.rgb(200, 200, 200));

     //--------------------------------coin ------------------------------------
    
      Label scoreLabel = new Label("");
      scoreLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));// Set font style
      scoreLabel.setTextFill(Color.WHITE);
      // Set position on X axis and Y axis
      scoreLabel.setTranslateX(100);
      scoreLabel.setTranslateY(45);

      
      
      // Create an image for the cube
Image coinsImage = new Image("/img/coin.png"); // Path to the coins image

// Create a cylinder with a radius and height
Cylinder coinsCylinder = new Cylinder(30, 5); // Radius 10 and height 20

// Apply the texture to the cylinder
PhongMaterial coinsMaterial = new PhongMaterial();
coinsMaterial.setDiffuseMap(coinsImage); // Set the texture (coins image)
coinsCylinder.setMaterial(coinsMaterial);

// Set the position for the cube (top-left of the screen)
coinsCylinder.setTranslateX(50);
coinsCylinder.setTranslateY(50);
coinsCylinder.setTranslateZ(0);

// Optional: Add rotation animation for the cube
RotateTransition coinsRotate = new RotateTransition(Duration.seconds(5), coinsCylinder);
coinsRotate.setByAngle(360);
coinsRotate.setAxis(Rotate.X_AXIS); // Rotate on Y-axis
coinsRotate.setCycleCount(RotateTransition.INDEFINITE);
coinsRotate.setInterpolator(Interpolator.LINEAR);
coinsRotate.play();

//------------------------------------------------------------------------------
    
    // Set up the main group
    Group gameRoot = new Group(sun,sunnLight,ambientLight,
          door1,door2,doorLeft,
            backgroundImageView1,characterBox,
            monster1, monster2,
            cube1, cube2, cube3,coinsCylinder,
            cloud1,cloud2,cloud3,cloud4,cloud5);

    // Set up the camera
    Camera camera = new PerspectiveCamera(true);
    camera.setNearClip(1);
    camera.setFarClip(4000);
    camera.setTranslateZ(-1100);
    camera.setTranslateX(WIDTH / 2.0);
    camera.setTranslateY(HEIGHT / 2.0);

    // Set up the scene
    Scene gameSceneFinal = new Scene(gameRoot, WIDTH, HEIGHT, true);
    gameSceneFinal.setCamera(camera);

    setupMonsterShooting(gameRoot, monster1, characterBox, Color.RED, Duration.seconds(2));// Set up monster shooting behavior
    setupMonsterShooting(gameRoot, monster2, characterBox, Color.RED, Duration.seconds(2));
    gameRoot.getChildren().add(scoreLabel); // Add score label to the scene
    setupCoins(gameRoot, characterBox, scoreLabel);// Set up coin behavior
    
    //-------------------------------------------------------------------
    // Set up keyboard controls for character movement
    gameSceneFinal.setOnKeyPressed(event -> {
        switch (event.getCode()) {
            case UP:
                characterBox.setTranslateY(characterBox.getTranslateY() - 10);
                break;
            case DOWN:
                characterBox.setTranslateY(characterBox.getTranslateY() + 10);
                break;
            case LEFT:
                characterBox.setTranslateX(characterBox.getTranslateX() - 10);
                break;
            case RIGHT:
                characterBox.setTranslateX(characterBox.getTranslateX() + 10);
                break;
        }

        
    });

    primaryStage.setTitle("Game: " + character);
    primaryStage.setScene(gameSceneFinal);
    primaryStage.show();
}


 //  move the cloud across the screen
    private void createCloudMovement(ImageView cloud) {
        // Set the cloud movement along the X-axis
        TranslateTransition translate = new TranslateTransition(Duration.seconds(10), cloud);
        translate.setByX(800); // The distance the cloud will travel across the screen
        translate.setCycleCount(TranslateTransition.INDEFINITE); // Set it to repeat
        translate.setAutoReverse(false); // No reverse movement after completion
        translate.setRate(1.0); // Speed
        translate.play();
        
      // Once the cloud exits the screen, reset its position to the other side
        translate.setOnFinished(e -> {
            cloud.setTranslateX(-cloud.getFitWidth()); 
            translate.play(); 
        });
    }
    //create a monster (box)
private Box createMonster(double startX, double startY) {
    Box monster = new Box(70, 70, 0); 
    monster.setTranslateX(startX); 
    monster.setTranslateY(startY); 

   // Set the material
    PhongMaterial monsterMaterial = new PhongMaterial();
    monsterMaterial.setDiffuseMap(new Image("/img/mooster.png")); 
    monster.setMaterial(monsterMaterial);

    return monster; 
}
//set up monster shooting at the character
private void setupMonsterShooting(Group root, Box monster, Box character, Color bulletColor, Duration bulletDuration) {
    
    Box bullet = new Box(10, 10, 10);
    bullet.setVisible(false); 

    PhongMaterial bulletMaterial = new PhongMaterial();
    bulletMaterial.setDiffuseColor(bulletColor);
    bullet.setMaterial(bulletMaterial);

   // Add the bullet to the scene
    root.getChildren().add(bullet);

     // Animation timer to handle monster shooting
    AnimationTimer monsterShootTimer = new AnimationTimer() {
        private long lastTime = 0;

        @Override
        public void handle(long now) {
            if (now - lastTime > 4_000_000_000L) { // Shoot every 4 seconds
                bullet.setTranslateX(monster.getTranslateX());// Set bullet position at the monster's position
                bullet.setTranslateY(monster.getTranslateY());
                bullet.setVisible(true);// Make the bullet visible

                // Bullet movement towards the character
                TranslateTransition bulletMovement = new TranslateTransition(bulletDuration, bullet);
                bulletMovement.setToX(character.getTranslateX());  // Set target X and Yposition of the bullet-character's position
                bulletMovement.setToY(character.getTranslateY()); 
                bulletMovement.setOnFinished(e -> bullet.setVisible(false)); // Hide bullet after movement finishes

                bulletMovement.play();

                lastTime = now;
            }
        }
    };
    monsterShootTimer.start();

    // Animation timer to check for collision between the bullet and the character
    AnimationTimer collisionChecker = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (bullet.isVisible() && bullet.getBoundsInParent().intersects(character.getBoundsInParent())) {
                stop(); // stop
                monsterShootTimer.stop(); //stop shooting

                // Display "Game Over" message
                Text over = new Text("Game Over!");
                over.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
                over.setFill(Color.ORANGE);
                over.setTranslateX(WIDTH / 2 - 100); // position X and Y for text 
                over.setTranslateY(HEIGHT / 2); 
                root.getChildren().add(over);// Add the "Game Over" text to the scene
            }
        }
    };
    collisionChecker.start();
}

//set up coins for the character
private void setupCoins(Group root, Box character, Label scoreLabel) {
    
    Image coinImage = new Image("/img/coin.png"); 
    ImageView[] coins = new ImageView[50]; // Create an array of 50 coins
    for (int i = 0; i < coins.length; i++) {
        coins[i] = new ImageView(coinImage); 
        coins[i].setFitWidth(30); // Set the width and height of the coin
        coins[i].setFitHeight(40); 
        coins[i].setTranslateX(100 + i * 150);  //Set X and Y position
        coins[i].setTranslateY(200); 
        coins[i].setVisible(false); // Hide coins initially 
        root.getChildren().add(coins[i]);// Add each coin to the scene
    }

    // Show the first coin
    coins[0].setVisible(true);

   
    // Variable to track score
    int[] score = {0};

      // Animation timer to check for coin collection
    AnimationTimer coinTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i].isVisible() && coins[i].getBoundsInParent().intersects(character.getBoundsInParent())) {
                    coins[i].setVisible(false); // Hide the coin once collected
                    // Update the score
                    score[0] += 1;
                    scoreLabel.setText(" " + score[0]);// Update

                    // Show the next coin if available
                    if (i + 1 < coins.length) {
                        coins[i + 1].setVisible(true);
                    }

                    break;// Stop checking after collecting a coin
                }
            }
        }
    };
    coinTimer.start();// Start the coin collection timer
}
public static void main(String[] args) {
    launch(args);
}
}