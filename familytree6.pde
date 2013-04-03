Tree familytree;
PImage bg;
PImage logo;
boolean t1 = false;
boolean t2 = false;
boolean t3 = false;
boolean t4 = false;
int a = -1;
int b = -1;
int c = -1;
int d = -1;
int f= 3;
int g= 0;
int j=0;
int hover = 0;
int l = 0;
color from = color(121,209,255);
  color to = color(33,255,0);
String [] theoname={"Diffusion","Use","Effects","Use & Effects","Structure & Content","Business Models","Regulation","Technical" ,"Non-Internet"};
int highlight;
int k;
String [] methodname={"Theoretical Devlopment","Review","Quantitative","Qualitative","Other"};
 String []indexname1 = {" "};
  String []indexname2 = {"Survey","Experiment","Content analysis","Field data","Econometrics","Simulation","Analyzing published data","Others"};
  String []indexname3 = {"Case study","In-depth interview/Focus group","Cultural/Critical studies","Field obeservation/Ethnography","Text/Semiotic/Discourse analysis"};
  String []indexname4 = {"System evaluation/Algorithm development","Policy/Regulation discussions","Miscellaneous"};
  int TorM_sel=0;
   int gary3 = 255;
   int gary4 = 0;
   int alpha1 = 200;
   int alpha2 = 80;
   int alpha3 = 255;
   int alpha4 = 150;
   int buttonl=(240-5)/2;
   int linestart = 278-2*buttonl-5;
   int hoverbutton = 0;
 

void setup(){
  size(1024,768);
  familytree = new Tree();
  smooth();
  //hint(ENABLE_STROKE_PURE);
  bg = loadImage("tittle2.png");
  logo = loadImage("bg2.png");
}

void draw(){
  background(255);
  image(bg,0,0);
  image(logo,0,0);
  //fill(255,0,0);
  //ellipse(500,100,100,100);
  //println(g);
  TorM();
  if(TorM_sel==0){
    index1();
  } else if(TorM_sel==1) {
  index2();
  }
    
  translate(0.5*width,0.88*height);
  familytree.play(t1,t2,t3,t4);
  familytree.gethl(g);
  familytree.gettm(TorM_sel);
  //saveFrame("frames/####.png");
  
    if(a==1){
      t1 = true;
    } else {
      t1 = false;
    }

    if(b==1){
      t2 = true;
    } else {
      t2 = false;
    }

    if(c==1){
      t3 = true;
    } else {
      t3 = false;
    }

    if(d==1){
      t4 = true;
    } else {
      t4 = false;
    }
    
}

void mouseReleased(){
 if(hover==1){
        a*=-1;
        b = -1;
        c = -1;
        d = -1;
      } else if (hover==2){
        b*=-1;
        a = -1;
        c = -1;
        d = -1;
      } else if (hover==3){
        c*=-1;
        a = -1;
        b = -1;
        d = -1;
      } else if (hover==4){
        d*=-1;
        a = -1;
        b = -1;
        c = -1;
      } else if (hover==0  && g==0 && hoverbutton == 0){// && g==0 && hoverbutton == 0
        a =-1;
        a = -1;
        b = -1;
        c = -1;
      }
   if(mouseX>270-2*buttonl-5 && mouseX<278-buttonl-5 && mouseY>=185 && mouseY<=185+20 && hover==0){
    TorM_sel = 0;
     gary3 = 255;
   gary4 = 0;
   alpha1 = 200;
   alpha2 = 80;
   alpha3 = 255;
   alpha4 = 150;
   
  } else if(mouseX>278-buttonl && mouseX<278 && mouseY>=185 && mouseY<=185+20 && hover==0){
    TorM_sel = 1;
   gary3 = 0;
   gary4 = 255;
   alpha1 = 80;
   alpha2 = 200;
   alpha3 = 150;
   alpha4 = 255;
  }
  
  if(mouseX>280 && mouseX<400 && mouseY>20 && mouseY<90){
    link("http://www6.cityu.edu.hk/com/");
  } else if(mouseX>280 && mouseX<400 && mouseY>110 && mouseY<200){
    link("http://weblab.com.cityu.edu.hk/blog/");
  } else if(mouseX>0 && mouseX<780 && mouseY>750 && mouseY<764){
    link("http://nms.sagepub.com/content/early/2012/11/22/1461444812462846.abstract");
  } else if(mouseX>930 && mouseX<1024 && mouseY>750 && mouseY<764){
    link("http://weibo.com/ayay");
  }
}  

void index1(){
     noStroke();
    int alpha = 100;
    
    j = familytree.gethighlight();
    hover = familytree.hoverdetct();
    //println(hover);
    /*
    if(mousePressed && (mouseButton == LEFT)){
      if(hover==1){
        a*=-1;
      } else if (hover==2){
        b*=-1;
      } else if (hover==3){
        c*=-1;
      } else if (hover==4){
        d*=-1;
      }
    }
      */ 
  for(int i=0;i<9;i++){
    //colorMode(HSB);
    if(mouseY > 22 && mouseY < 22+18*9 && mouseX > 600){
      if(mouseY >= 22+18*i && mouseY <= 22+18*i+14){
        k = i;
        g = k+1;
      } 
 
      if(i==k){
        alpha = 255;
      } else {
        alpha = 100;
      }
    } else if(j>0 && hover > 0){
      if(i==(j-1)){
        alpha = 255;
      } else {
        alpha = 100;
      }
    } else {
      alpha = 255;
      g = 0;
    }
      
    fill(lerpColor(from,to,i*0.08),alpha);
    //fill(70+i*15,170,230,150);
    rect(820-i*26,22+18*i,130+i*12,14);
    fill(50,200);
    textAlign(LEFT,CENTER);
    textSize(12);
    text(theoname[i],825-i*26,27+18*i);
  }
  
  
  
  
  colorMode(RGB);
  strokeWeight(30);
  stroke(255);
  fill(255);
  arc(990,180,300,300,PI,3*PI/2);
  noFill();
  stroke(200,100);
  arc(990,180,280,280,PI,3*PI/2);
  stroke(255,80,153);
  strokeWeight(23);
  arc(995,180,280,280,PI,11*PI/8);
  textSize(18);
  fill(255,0,0);
  textAlign(CENTER,CENTER);
  text("Theoretically Oriented %",875,60,140,140);
  rectMode(CORNER);
}

void index2(){
  colorMode(HSB);
   color c3 = color(141,255,255*0.99);
  color c4 = color(126,255,255*0.99);
  color c5 = color(98,255,255*0.99);
  color c1 = color(44,255,255*0.99);
  color c2 = color(33,255,255*0.99);
  color [] c = {c1,c2,c3,c4,c5};
  float hc1 = hue(c1);
  float hc2 = hue(c2);
  float hc3 = hue(c3);
  float hc4 = hue(c4);
  float hc5 = hue(c5);
   float sc1 = saturation(c1);
   float sc2 = saturation(c2);
   float sc3 = saturation(c3);
   float sc4 = saturation(c4);
   float sc5 = saturation(c5);
   float co1 = hc1;
   float co2 = sc1;
     noStroke();
    int alpha = 100;
    
    j = familytree.gethighlight();
    hover = familytree.hoverdetct();
    //println(k);

  //ellipse(990,180,10,10);
   PVector mousevector = new PVector(mouseX-990,mouseY-180);
   PVector reference = new PVector(-1,0);
   if(mousevector.mag() <= 140 && mouseY<180 && mouseX<990){
     k = ceil(PVector.angleBetween(mousevector,reference)/(PI/10));
     g = k;
     l=1;
   } else {
     l = 0;
   }
  
    int num = 0;
  //String [] indexname; 
   if(j == 1){
      num = 0;
      
    } else if(j == 2){
      num = 0;
     
    } else if(j == 3){
      num = 8;
      
    } else if(j == 4){
      num = 5;
     
    } else if(j == 5){
      num = 3;
      
    }
    
    for(int i=0;i<num;i++){
      noStroke();
    if(j==1){
      //fill(hc1,sc1,255*0.99,alpha);
      co1 = hc1;
      co2 = sc1;
    } else if(j==2){
      //fill(hc2,sc2,255*0.99,alpha);
      co1 = hc2;
      co2 = sc2;
    } else if(j==3){
      //fill(hc3,sc3-(i-3)*10,255*099,alpha);
      co1 = hc3;
      co2 = sc3-i*35;
    } else if(j==4){
      //fill(hc4,sc4-(i-11)*10,255*099,alpha);
      co1 = hc4;
      co2 = sc4-i*50;
    } else if(j==5){
      //fill(hc5,sc5-(i-16)*10,255*099,alpha);
      co1 = hc5;
      co2 = sc5-i*65;
    }
    //fill(70+i*15,170,230,150);
    fill(co1,co2,255*0.99);
    rect(820-i*26*8/(num-1),22+18*8/(num-1)*i,130+i*12*8/(num-1),14);
    fill(50,200);
    textAlign(LEFT,CENTER);
    textSize(12);
        if(j == 1 ||j == 2){
      text(indexname1[i],820-i*26*8/(num-1),22+18*8/(num-1)*i);
     
    } else if(j == 3){
      text(indexname2[i],820-i*26*8/(num-1),22+18*8/(num-1)*i);
      
    } else if(j == 4){
      text(indexname3[i],820-i*26*8/(num-1),22+18*8/(num-1)*i);
     
    } else if(j == 5){
      if(i==0){
        text(indexname4[i],820-i*26*8/(num-1)-100,22+18*8/(num-1)*i);
      } else if(i==1){
      text(indexname4[i],820-i*26*8/(num-1)-50,22+18*8/(num-1)*i);
      } else {
        text(indexname4[i],820-i*26*8/(num-1),22+18*8/(num-1)*i);
    }
    }
    }
  
  
  colorMode(RGB);
   strokeWeight(30);
  stroke(255);
  fill(255);
  arc(990,180,300,300,PI,3*PI/2);
  noFill();
  //stroke(100,100);
  //arc(990,180,280,280,PI,3*PI/2);
  for(int i=0;i<5;i++){
   if(l>0){
    if(i==(k-1)){
        alpha = 255;
      } else {
        alpha = 50;
      }
   } else {
    if(j>0 && hover > 0){
      if(i==(j-1)){
        alpha = 255;
      } else {
        alpha = 50;
      }
    } else {
      alpha = 255;
      g = 0;
    }
   }
  stroke(c[i],alpha);
  arc(990,180,280,280,PI+i*PI/10+0.005*PI,PI+(i+1)*PI/10-0.005*PI);
  }
  textSize(18);
  fill(255,0,0);
  textAlign(CENTER,CENTER);
  if(j==0){
    text("Select a Method",875,60,140,140);
  } else {
  text(methodname[j-1],875,60,140,140);
  }
  rectMode(CORNER);
  //println(j);  
}

void TorM(){
  if(mouseX>270-2*buttonl-5 && mouseX<278-buttonl-5 && mouseY>=185 && mouseY<=185+20){
    cursor(HAND);
    hoverbutton = 1;
    linestart =   278-2*buttonl-5;
  
    
  } else if(mouseX>278-buttonl && mouseX<278 && mouseY>=185 && mouseY<=185+20){
  hoverbutton = 1;
  cursor(HAND);
  linestart =   278-buttonl;
  } else if(hover >0 || g>0){
  cursor(HAND);
  } else if(mouseX>280 && mouseX<400 && mouseY>20 && mouseY<90){
    cursor(HAND);
  } else if(mouseX>280 && mouseX<400 && mouseY>110 && mouseY<200){
    cursor(HAND);
  } else if(mouseX>0 && mouseX<780 && mouseY>750 && mouseY<764){
    cursor(HAND);
  } else if(mouseX>930 && mouseX<1024 && mouseY>750 && mouseY<764){
    cursor(HAND);
  } else {
    cursor(ARROW);
    hoverbutton = 0;
  }
  noStroke();
  fill(100,alpha1);
  rect(278-2*buttonl-5,185,buttonl,20);
  fill(100,alpha2);
  rect(278-buttonl,185,buttonl,20);
  fill(gary3,alpha3);
  textSize(15);
  text("Theory",280-1.5*buttonl-5,194);
  fill(gary4,alpha4);
  text("Method",278-0.5*buttonl,194);
       stroke(121,218,252);
  strokeWeight(2);  
   line(linestart,207,linestart+buttonl,207);

}


