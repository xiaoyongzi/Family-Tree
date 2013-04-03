import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class familytree6 extends PApplet {

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
int from = color(121,209,255);
  int to = color(33,255,0);
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
 

public void setup(){
  size(1024,768);
  familytree = new Tree();
  smooth();
  //hint(ENABLE_STROKE_PURE);
  bg = loadImage("tittle2.png");
  logo = loadImage("bg2.png");
}

public void draw(){
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
    
  translate(0.5f*width,0.88f*height);
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

public void mouseReleased(){
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

public void index1(){
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
      
    fill(lerpColor(from,to,i*0.08f),alpha);
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

public void index2(){
  colorMode(HSB);
   int c3 = color(141,255,255*0.99f);
  int c4 = color(126,255,255*0.99f);
  int c5 = color(98,255,255*0.99f);
  int c1 = color(44,255,255*0.99f);
  int c2 = color(33,255,255*0.99f);
  int [] c = {c1,c2,c3,c4,c5};
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
    fill(co1,co2,255*0.99f);
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
  arc(990,180,280,280,PI+i*PI/10+0.005f*PI,PI+(i+1)*PI/10-0.005f*PI);
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

public void TorM(){
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
  text("Theory",280-1.5f*buttonl-5,194);
  fill(gary4,alpha4);
  text("Method",278-0.5f*buttonl,194);
       stroke(121,218,252);
  strokeWeight(2);  
   line(linestart,207,linestart+buttonl,207);

}


class Tree{
  String[] main1 = {"e-Health","e-Business","e-Society","Human-Tech Interactions"};
  float[]  main2 ={0.27f,0.18f,0.21f,0.34f,0};
  Branch[] branches;
  int[] branch1weight; 
  int weight = 80;
  int highlight;
  int tmselect;
  
  Tree(){
    branches = new Branch[main1.length];
    branch1weight = new int[main1.length];
    float branch1startxadd = 0;
    for(int i=0;i<main1.length; i++){
      float branch1startx;
      branch1weight[i] = (int)(main2[i] * weight);
      if(i == 0){
        branch1startx = -0.5f*weight+0.5f*branch1weight[0];
      } else {
        branch1startxadd += 0.5f*(branch1weight[i]+branch1weight[i-1]);
        branch1startx = -0.5f*weight+0.5f*branch1weight[0]+branch1startxadd;
      }
      PVector branch1start = new PVector(branch1startx,0);
      branches[i] = new Branch(branch1start,branch1weight[i],i+1,100+i*20);
      //branches[i] = new Branch(branch1start,branch1weight[i],i+1,255);
    }
  }
  
   public void play(boolean trigger1, boolean trigger2, boolean trigger3, boolean trigger4){
     branches[0].trans(trigger1);
     branches[1].trans(trigger2);
     branches[2].trans(trigger3);
     branches[3].trans(trigger4);
     for(int i=0; i< branches.length; i++){
       branches[i].gethl(highlight);
       branches[i].display();
       branches[i].label(main1[i],main2[i]);
       branches[i].tmdetect(tmselect);
     }
     //println(gethighlight());
   }
   
   public void gethl(int highlight){
     this.highlight = highlight;
   }
   
   public int gethighlight(){
    int [] hls = new int[branches.length];
    for(int i=0;i<branches.length;i++){
      hls[i] = branches[i].gethighlight();
    }
    int hlight = max(hls);
    return hlight;
  }
  
  public int hoverdetct(){
    int hovernumber = 0;
    int [] hoverd = new int[branches.length];
    for(int i=0;i<branches.length;i++){
      hoverd[i] = branches[i].hoverdetect();
    }
    int hover = max(hoverd);
    for(int i=0;i<branches.length;i++){
      if(hover>0 && hover == hoverd[i]){
        hovernumber = i+1;
      }
    }
     return hovernumber;
  }
  
  public void gettm(int tmselect){
    this.tmselect = tmselect;
  }
  
}
    
    
class Gbezier{
  
PVector Start;
PVector StartCon;
PVector End;
PVector EndCon;
PVector Target;
float bezierstrokeWeight;
float strokecolor;

Gbezier(PVector Start, PVector StartCon, PVector EndCon, PVector End){
  this.Start= Start;
  this.StartCon = StartCon;
  this.End = End;
  this.EndCon = EndCon;
}

public void display(){
  strokeCap(SQUARE);
  strokeWeight(bezierstrokeWeight);
  stroke(strokecolor,200);
  noFill();
  bezier(Start.x,Start.y,StartCon.x,StartCon.y,EndCon.x,EndCon.y,End.x,End.y);
}

public void setweight(float bezierstrokeWeight){
  this.bezierstrokeWeight = bezierstrokeWeight;
}

public void setcolor(float strokecolor){
  this.strokecolor = strokecolor;
}

public void transall(PVector Start1, PVector StartCon1, PVector EndCon1, PVector End1){
  update(Start, Start1);
  update(StartCon,StartCon1);
  update(End, End1);
  update(EndCon,EndCon1);
}

public void transhalf(PVector Start1, PVector StartCon1, PVector EndCon1, PVector End1){
  Start = Start1;
  update(StartCon,StartCon1);
  update(End, End1);
  update(EndCon,EndCon1);

}

public void transend(PVector End1, PVector EndCon1){
  update(End, End1);
  update(EndCon,EndCon1);
}

public void update(PVector pos, PVector target){
  float vel = 0.05f;
  PVector v= PVector.div((PVector.sub(target,pos)),1/vel);
  if(pos==target){
  }else{
   pos.add(v);
  }
}

public PVector getEnd(){
  return End;   
}

public PVector getEndcon(){
  return EndCon;   
}

}


class Theory{
  float centerx;
  float centery;
  float r;
  float innerper;
  float outper;
  float inner;
  float out;
  int id;
  float [] data;
  String[] columnnames;
  String[] columnnames2;
  int columnIndex;
  int columnIndex2;
  float [] value;
    float [] methodclass1;
  float [] methodclass2;
  int highlight=0;
  int from = color(121,209,255);
  int to = color(33,255,0);
  int hover = 0;
 int highlights = 0;
  int highlighte = 0;
  PFont font;


Theory(PVector center, float _r, String columnname){
  font = loadFont("GillSans-Light-24.vlw");
  centerx = center.x;
  centery = center.y;
  r = _r;
  
  String[] rows = loadStrings("theory.txt");
  columnnames = split(rows[1], TAB);
  //println(columnnames);
  for(int i=0;i<columnnames.length;i++){
    if(columnnames[i].equals(columnname)){
      columnIndex = i;
      //println(columnIndex);
    }
  }
  value = new float[rows.length-2];
 for(int i=2; i < rows.length; i++){
   String [] pieces = split(rows[i], TAB);
   //println(pieces);
   value[i-2] = parseFloat(pieces[columnIndex]);
}

 //===================Method===================//
 String[] rows2 = loadStrings("method.txt");
 columnnames2 = split(rows2[0],TAB);
 for(int i=0;i<columnnames2.length;i++){
   if(columnnames2[i].equals(columnname)){
     columnIndex2 = i;
   }
 }
   //println(columnIndex2);
   methodclass1 = new float[5];
   methodclass2 = new float[18];
   for(int i=1; i<rows2.length;i++){
     String [] pieces = split(rows2[i], TAB);
     if(i<6){
       methodclass1[i-1] = parseFloat(pieces[columnIndex2]);
     } else {
       methodclass2[i-6] = parseFloat(pieces[columnIndex2]);
     }
   }
  
}

public void display(int MorT){
  if(MorT == 0){
    angle2highlight();
    outchart();
    innerarc();
  } else {
    angle2highlight2();
    innercircle();
}

}

public void innerarc(){
  colorMode(RGB);
  innerper = value[0];
  inner = map(innerper,0,1,0,2*PI);
  pushMatrix();
  translate(centerx,centery);
  //stroke(2);
  fill(255);
  ellipse(0,0,2*r+3,2*r+3);
  noStroke();
  fill(100,100);
  ellipse(0,0,2*r,2*r);
  fill(255,54,138);//255,80,153 255,54,138
  arc(0,0,2*r,2*r,PI/2,PI/2+inner);
  fill(255);
  ellipse(0,0,2*r*0.7f,2*r*0.7f);
  fill(255,0,0);
  if(highlight == 0){
      fill(255,0,0);
    } else {
      fill(lerpColor(from,to,(highlight-1)*0.111111f));
      //fill(255,0,0);
      //println(col);
    }
  textSize(r/1.8f);
  textAlign(CENTER,CENTER);
  text(PApplet.parseInt(100*value[highlight])+"%",0,0);
  popMatrix();
}

public void outchart(){
  //colorMode(HSB);
  int alpha;
  pushMatrix();
  translate(centerx,centery);
  noStroke();
  float theoryCount = value.length;
  for(int i=1;i<theoryCount;i++){
    outper = value[i];
    //println(outper);
    out = map(outper,0,1,2*r,8*r);
    //rotate(2*PI/9);
    if(highlight == 0){
      //fill(70+i*15,170,230,230);
      fill(lerpColor(from,to,(i-1)*0.111111f));
    } else {
      if(i == highlight){
        alpha = 255;
      } else {
        alpha = 50;
      }
      //fill(70+i*15,170,230,alpha);
      fill(lerpColor(from,to,(i-1)*0.111111f),alpha);
    }
    //strokeWeight(2);
    //stroke(255);
    arc(0,0,out,out,2*PI/9*i,1.9f*PI/9+2*PI/9*i);
  }
  popMatrix();
}

public void innercircle(){
  int alpha;
  colorMode(HSB);
   int c3 = color(141,255,255*0.99f);
  int c4 = color(126,255,255*0.99f);
  int c5 = color(98,255,255*0.99f);
  int c1 = color(44,255,255*0.99f);
  int c2 = color(33,255,255*0.99f);
  int [] c = {c1,c2,c3,c4,c5};
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
   float co3;
  pushMatrix();
  translate(centerx, centery);
  noStroke();
    float add1 = 0;
  float add2 = 0;
  float add3 = 0;
  float add4 = 0;

  for(int i=1; i<=methodclass1.length; i++){
    colorMode(HSB);
     if(highlight == 0){
      //fill(70+i*15,170,230,230);
      fill(c[i-1]);
    } else {
      if(i == highlight){
        alpha = 255;
      } else {
        alpha = 50;
      }
      //fill(70+i*15,170,230,alpha);
      //fill(lerpColor(from,to,(i-1)*0.111),alpha);
      fill(c[i-1],alpha);
      textSize(r/1.5f);
      textAlign(CENTER,CENTER);
      text(PApplet.parseInt(100*methodclass1[highlight-1])+"%",0,0);
    }
    
    
    add4 += methodclass1[i-1];
    arc(0,0,3.5f*r,3.5f*r,2*PI*add3+0.01f*PI,2*PI*add4-0.01f*PI);
    add3 += methodclass1[i-1];
    }
   
    fill(255);
  ellipse(0,0,3*r,3*r);
 
  
  for(int i=1; i<=methodclass2.length; i++){
     if(highlight == 0){
      //fill(70+i*15,170,230,230);
      alpha = 255;
    } else {
      if(i>= highlights && i<=highlighte){
        alpha = 255;
        //println(methodclass1[i]);
      } else {
        alpha = 50;
      }
      //fill(70+i*15,170,230,alpha);
    }
    
    if(i==1){
      //fill(hc1,sc1,255*0.99,alpha);
      co1 = hc1;
      co2 = sc1;
    } else if(i==2){
      //fill(hc2,sc2,255*0.99,alpha);
      co1 = hc2;
      co2 = sc2;
    } else if(i>2 && i<=10){
      //fill(hc3,sc3-(i-3)*10,255*099,alpha);
      co1 = hc3;
      co2 = sc3-(i-3)*35;
    } else if(i>10 && i<=15){
      //fill(hc4,sc4-(i-11)*10,255*099,alpha);
      co1 = hc4;
      co2 = sc4-(i-11)*50;
    } else if(i>15 && i<=18){
      //fill(hc5,sc5-(i-16)*10,255*099,alpha);
      co1 = hc5;
      co2 = sc5-(i-16)*65;
    }
    fill(co1,co2,255*0.99f,alpha);
    //fill(lerpColor(from,to,(i-1)*0.2),alpha);
    add2 += methodclass2[i-1];
    arc(0,0,2.5f*r,2.5f*r,2*PI*add1+0.005f*PI,2*PI*add2-0.005f*PI);
    add1 += methodclass2[i-1];
  }
  
  /*  for(int i=1; i<methodclass1.length; i++){
     fill(255);
    add3 += methodclass1[i-1];
    add4 += methodclass1[i];
    //arc(0,0,1.5*r,1.5*r,2*PI*methodclass1[0],2*PI*methodclass1[0]+0.005*PI);
    arc(0,0,1.5*r,1.5*r,2*PI*add4-0.005*PI,2*PI*add4);
  }*/

  fill(255);
  ellipse(0,0,1.5f*r,1.5f*r);
  
  //fill(255,0,0);
    for(int i=1; i<=methodclass1.length; i++){
     if(highlight == 0){
      //fill(70+i*15,170,230,230);
      //fill(lerpColor(from,to,(i-1)*0.111));
    } else {
      if(i == highlight){
        alpha = 255;
      } else {
        alpha = 50;
      }
      //fill(70+i*15,170,230,alpha);
      fill(lerpColor(from,to,(i-1)*0.111f),alpha);
      textSize(r/1.7f);
      textAlign(CENTER,CENTER);
      text(PApplet.parseInt(100*methodclass1[highlight-1])+"%",0,0);
    }
  }
  

  popMatrix();
  colorMode(RGB);
}

public void label(String label, String value){
  pushMatrix();
  translate(centerx,centery);
  textAlign(LEFT);
  textFont(font,20);
  textSize(15);
  fill(100,200);
  text(label,2*r,-0.5f*r);
  textSize(22);
  colorMode(HSB);
  fill(85,233,200);
  text(parseInt(100*parseFloat(value))+" %",2.2f*r,0.2f*r);
  popMatrix();
}

public void label2(String label, String value){
  pushMatrix();
  translate(centerx,centery);
  textAlign(CENTER);
  textFont(font,12);
  textSize(12);
  fill(100,100);
  text(label,-1.5f*r,-6*r,60,110);
  //println(label);
  //textSize(24);
  //text(parseInt(100*parseFloat(value))+" %",1.5*r,0.2*r);
  popMatrix();
}


public void updatepos(float posx, float posy){
  centerx = posx;
  centery = posy;
}

public void angle2highlight(){
  PVector mousevector = new PVector(mouseX-centerx-0.5f*width,mouseY-centery-0.88f*height);
  pushMatrix();
  //translate(centerx,centery);
  PVector referencex = new PVector(1,0);
  referencex.rotate(2*PI/9);
  PVector referencey = new PVector(0,-1);
  referencey.rotate(2*PI/9);
  if(mousevector.mag() <= 2.4f*r){
    hover = 1;
    cursor(HAND);
    if(PVector.angleBetween(mousevector,referencey)>(PI/2)){
    highlight = ceil(PVector.angleBetween(mousevector,referencex)/(2*PI/9));
    //println(PVector.angleBetween(mousevector,referencey));
    } else {
       highlight = 10-ceil(PVector.angleBetween(mousevector,referencex)/(2*PI/9));
     }
  } else {
    hover = 0;
  }
  //println(degrees(PVector.angleBetween(mousevector,referencey)));
  popMatrix();
}

public void angle2highlight2(){
    float adda = 0;
  float addb = 0;
  float addc = 0;
  float addd = 0;

    PVector mousevector = new PVector(mouseX-centerx-0.5f*width,mouseY-centery-0.88f*height);
  //println(mousevector);
  pushMatrix();
  //translate(centerx,centery);
  PVector referencex = new PVector(1,0);
  PVector referencey = new PVector(0,-1);
  
  if(mousevector.mag() <= 3.5f*r/2){
    hover = 1;
    for(int i=1; i<methodclass1.length+1; i++){
      if(i==1){
        addc = 0;
        addd = methodclass1[0];
      } else {
    addc += methodclass1[i-2];
    addd += methodclass1[i-1];
      }
    if(PVector.angleBetween(mousevector,referencey)>(PI/2)){
      if(PVector.angleBetween(mousevector,referencex)>addc*2*PI && PVector.angleBetween(mousevector,referencex)<addd*2*PI){
        highlight = i;
        break;
      }
    } else {
    if(2*PI-PVector.angleBetween(mousevector,referencex)<addc*2*PI && PVector.angleBetween(mousevector,referencex)<addd*2*PI){
        highlight = i;
        break;
      }
    }
    }
      

    
  } else {
    hover = 0;
    //highlight = 0;
  }
  
  if(mousevector.mag() > r){
   // println(r);
  }
      if(highlight == 1){
      highlights = 1;
      highlighte = 1;
    } else if(highlight == 2){
      highlights = 2;
      highlighte = 2;
    } else if(highlight == 3){
      highlights = 3;
      highlighte = 10;
    } else if(highlight == 4){
      highlights = 11;
      highlighte = 15;
    } else if(highlight == 5){
      highlights = 16;
      highlighte = 18;
    }
    

  //println(degrees(PVector.angleBetween(mousevector,referencey)));
  popMatrix();
  //println(highlight);
}

public int gethighlight(){
  return highlight;
}


public void updatehighlight(int highlight){
  this.highlight = highlight;
}

public void bigger(boolean ok){
  if(ok){
    transR(40);
  } else {
    transR(20);
  }
}

public int hoverdetect(){
  return hover;
}

public void transR(float R){
  float t = 0.05f;
  if( r == R ){
  } else {
    r += (R-r)*t;
  }
}

}
  
class Branch{
  //float[] t
  //PFont font;
  int num;
  int gray;
  int highlight;
  float allwidth;
  int tmselect;
  Gbezier branch1;
  Gbezier[] branch2;
  Theory [] theories;
  String[][] branch2data;
  PVector branch1end;
  PVector branch1endcon;
  float middlelevel=-0.18f*height;
  float toplevel = -0.3f*height;
  float branch1border=width/6;
  float branch2width = 0.22f*(width-2*branch1border);
  PVector downvector1 = new PVector(0, -(middlelevel/2));
  PVector upvector1 = new PVector(0, (middlelevel/2));
  
   PVector downvector4 = new PVector(0, -1.1f*(middlelevel));
  PVector upvector4 = new PVector(0, (middlelevel/1.6f));
  
  PVector downvector2 = new PVector(0, -((toplevel-middlelevel)/2));
  PVector upvector2 = new PVector(0, ((toplevel-middlelevel)/1.5f));
  
    PVector downvector3 = new PVector(0, -((toplevel-middlelevel)*2));
  PVector upvector3 = new PVector(0, ((toplevel-middlelevel)*1.3f));
  
  float leftbranch1endx = -(width/2-branch1border);
  float branch1interval = (width-2*branch1border)/3;
  float weight = 80;
  float branch1weight;
  int branch1index;
  int a = -1;
  
  
  Branch(PVector branch1start,float branch1weight, int branch1index, int gray){
    //font = loadFont("GillSans-Light-24.vlw");
    this.branch1index = branch1index;
    this.branch1weight = branch1weight;
    this.gray = gray;
    branch1end = new PVector( leftbranch1endx + (branch1index-1) * branch1interval, middlelevel );
    branch1endcon = PVector.add(branch1end,downvector1);
    PVector branch1startcon = PVector.add(branch1start,upvector1);
    
    branch1 = new Gbezier(branch1start, branch1startcon, branch1endcon, branch1end);
    branch1.setweight(branch1weight);
    branch1.setcolor(gray);
    
    String[] rows = loadStrings("branch2.txt");
    branch2data = new String[2][];
    int row = (branch1index-1)*2;
    branch2data[0] = subblank(split(rows[row],TAB));
    branch2data[1] = subblank(split(rows[row+1],TAB));
    num = branch2data[0].length;
    //println(branch2data[0]);
    //println(branch2data[1]);
    branch2 = new Gbezier[num];
    theories = new Theory[num];
    float branch2startxadd = 0;    
    for(int i=0; i<num; i++){
      float branch2weighti;
      float branch2weightii;
      if(i==0){
        branch2weighti = weight * parseFloat(branch2data[1][i]); 
      } else {
        branch2weighti = weight * parseFloat(branch2data[1][i]); 
        branch2weightii = weight * parseFloat(branch2data[1][i-1]);
        branch2startxadd += 0.5f*(branch2weighti + branch2weightii); 
      }
      
      float branch2startx = branch1end.x - branch1weight/2 + branch2weighti/2 + branch2startxadd;
      PVector branch2start = new PVector(branch2startx, branch1end.y+0.5f);
      float branch2endx = branch1end.x-0.5f*branch2width+branch2width*i/(num-1);
      PVector branch2end = new PVector(branch2endx,toplevel);
      PVector branch2startcon = PVector.add(branch2start,upvector2);
      PVector branch2endcon = PVector.add(branch2end,downvector2);
      
      branch2[i] = new Gbezier(branch2start, branch2startcon, branch2endcon, branch2end);
      branch2[i].setweight(branch2weighti);
      branch2[i].setcolor(gray);
      theories[i] = new Theory(branch2end, 20, branch2data[0][i]);
    }
  }
  
  public String[] subblank(String[] array){
    for(int i=array.length-1; i>0; i--){
    if(array[array.length-1].equals("")){
      array = subset(array,0,array.length-1);
    }
  }
  return array;
  }
      
  
  public void display(){
    for(int i=0;i<num;i++){
      branch2[i].display();
      theories[i].display(tmselect);
    }
     branch1.display();
     //println(gethighlight());   
  }
  
  public void trans(boolean ok){
    PVector branch1endnew;
    PVector branch1endconnew;
    if(ok){
      middlelevel = -0.3f*height;
      toplevel = -0.54f*height;
      branch1endnew= new PVector( leftbranch1endx + (branch1index-1) * branch1interval, middlelevel);
      branch1endconnew = PVector.add(branch1endnew,downvector4);
    } else {
      middlelevel= -0.18f*height;
      toplevel = -0.3f*height;
       branch1endnew = new PVector( leftbranch1endx + (branch1index-1) * branch1interval, middlelevel,0 );
      branch1endconnew = PVector.add(branch1end,downvector1);
      
    }
     branch1.transend(branch1endnew,branch1endconnew);
      run(ok);
  }

  public void run(boolean okk){
    float branch2startxadd = 0;    
    for(int i=0; i<num; i++){
      float branch2weighti;
      float branch2weightii;
      if(i==0){
        branch2weighti = weight * parseFloat(branch2data[1][i]); 
      } else {
        branch2weighti = weight * parseFloat(branch2data[1][i]);
        branch2weightii = weight * parseFloat(branch2data[1][i-1]);
        branch2startxadd += 0.5f*(branch2weighti + branch2weightii); 
      }
      float branch2startx = branch1end.x - 0.5f*branch1weight + 0.5f*(weight * parseFloat(branch2data[1][0])) + branch2startxadd;
      PVector branch2start = new PVector(branch2startx-0.1f, branch1end.y+0.15f);
      float branch2endx;
      PVector branch2end;
      PVector branch2startcon;
      PVector branch2endcon;
      if(okk){
        branch2endx = -width/2+width/(num*2)+width*i/num;
         branch2end = new PVector(branch2endx,toplevel);
         branch2startcon = PVector.add(branch2start,upvector3);
         branch2endcon = PVector.add(branch2end,downvector3);
         theories[i].label(branch2data[0][i],branch2data[1][i]);
      } else {
        branch2endx = branch1end.x-0.5f*branch2width+branch2width*i/(num-1);
         branch2end = new PVector(branch2endx,toplevel);
         branch2startcon = PVector.add(branch2start,upvector2);
         branch2endcon = PVector.add(branch2end,downvector2);
         theories[i].label2(branch2data[0][i],branch2data[1][i]);
      }
     
      branch2[i].transhalf(branch2start, branch2startcon, branch2endcon, branch2end);
      theories[i].updatepos(branch2[i].getEnd().x,branch2[i].getEnd().y);
      theories[i].bigger(okk);
      theories[i].updatehighlight(highlight);
      //ellipse(branch2[i].getEnd().x,branch2[i].getEnd().y,5,5);
      //ellipse(branch2[i].getEndcon().x,branch2[i].getEndcon().y,5,5);
      //ellipse(200,toplevel,10,10);
    } 
  }
  
  
  public void gethl(int highlight){
    this.highlight = highlight;
  }
  
  public int gethighlight(){
    int [] hls = new int[num];
    for(int i=0;i<num;i++){
      hls[i] = theories[i].gethighlight();
    }
    int hlight = max(hls);
    return hlight;
  }
  
  
  public int hoverdetect(){
    int [] hoverd = new int[num];
    for(int i=0;i<num;i++){
      hoverd[i] = theories[i].hoverdetect();
    }
    int hover = max(hoverd);
    return hover;
  }
  
  public void label(String name, float percent){
    //textFont(font,20);
    fill(86,170,230);
    textAlign(CENTER,CENTER);
    //rectMode(CENTER);
    //text(parseInt(percent*100)+"%  "+name,leftbranch1endx + (branch1index-1) * branch1interval,40);
  }
  
  public void tmdetect(int tmselect){
    this.tmselect = tmselect;
  }
}
  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "familytree6" });
  }
}
