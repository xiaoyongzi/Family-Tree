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
  color from = color(121,209,255);
  color to = color(33,255,0);
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

void display(int MorT){
  if(MorT == 0){
    angle2highlight();
    outchart();
    innerarc();
  } else {
    angle2highlight2();
    innercircle();
}

}

void innerarc(){
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
  ellipse(0,0,2*r*0.7,2*r*0.7);
  fill(255,0,0);
  if(highlight == 0){
      fill(255,0,0);
    } else {
      fill(lerpColor(from,to,(highlight-1)*0.111111));
      //fill(255,0,0);
      //println(col);
    }
  textSize(r/1.8);
  textAlign(CENTER,CENTER);
  text(int(100*value[highlight])+"%",0,0);
  popMatrix();
}

void outchart(){
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
      fill(lerpColor(from,to,(i-1)*0.111111));
    } else {
      if(i == highlight){
        alpha = 255;
      } else {
        alpha = 50;
      }
      //fill(70+i*15,170,230,alpha);
      fill(lerpColor(from,to,(i-1)*0.111111),alpha);
    }
    //strokeWeight(2);
    //stroke(255);
    arc(0,0,out,out,2*PI/9*i,1.9*PI/9+2*PI/9*i);
  }
  popMatrix();
}

void innercircle(){
  int alpha;
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
      textSize(r/1.5);
      textAlign(CENTER,CENTER);
      text(int(100*methodclass1[highlight-1])+"%",0,0);
    }
    
    
    add4 += methodclass1[i-1];
    arc(0,0,3.5*r,3.5*r,2*PI*add3+0.01*PI,2*PI*add4-0.01*PI);
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
    fill(co1,co2,255*0.99,alpha);
    //fill(lerpColor(from,to,(i-1)*0.2),alpha);
    add2 += methodclass2[i-1];
    arc(0,0,2.5*r,2.5*r,2*PI*add1+0.005*PI,2*PI*add2-0.005*PI);
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
  ellipse(0,0,1.5*r,1.5*r);
  
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
      fill(lerpColor(from,to,(i-1)*0.111),alpha);
      textSize(r/1.7);
      textAlign(CENTER,CENTER);
      text(int(100*methodclass1[highlight-1])+"%",0,0);
    }
  }
  

  popMatrix();
  colorMode(RGB);
}

void label(String label, String value){
  pushMatrix();
  translate(centerx,centery);
  textAlign(LEFT);
  textFont(font,20);
  textSize(15);
  fill(100,200);
  text(label,2*r,-0.5*r);
  textSize(22);
  colorMode(HSB);
  fill(85,233,200);
  text(parseInt(100*parseFloat(value))+" %",2.2*r,0.2*r);
  popMatrix();
}

void label2(String label, String value){
  pushMatrix();
  translate(centerx,centery);
  textAlign(CENTER);
  textFont(font,12);
  textSize(12);
  fill(100,100);
  text(label,-1.5*r,-6*r,60,110);
  //println(label);
  //textSize(24);
  //text(parseInt(100*parseFloat(value))+" %",1.5*r,0.2*r);
  popMatrix();
}


void updatepos(float posx, float posy){
  centerx = posx;
  centery = posy;
}

void angle2highlight(){
  PVector mousevector = new PVector(mouseX-centerx-0.5*width,mouseY-centery-0.88*height);
  pushMatrix();
  //translate(centerx,centery);
  PVector referencex = new PVector(1,0);
  referencex.rotate(2*PI/9);
  PVector referencey = new PVector(0,-1);
  referencey.rotate(2*PI/9);
  if(mousevector.mag() <= 2.4*r){
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

void angle2highlight2(){
    float adda = 0;
  float addb = 0;
  float addc = 0;
  float addd = 0;

    PVector mousevector = new PVector(mouseX-centerx-0.5*width,mouseY-centery-0.88*height);
  //println(mousevector);
  pushMatrix();
  //translate(centerx,centery);
  PVector referencex = new PVector(1,0);
  PVector referencey = new PVector(0,-1);
  
  if(mousevector.mag() <= 3.5*r/2){
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

int gethighlight(){
  return highlight;
}


void updatehighlight(int highlight){
  this.highlight = highlight;
}

void bigger(boolean ok){
  if(ok){
    transR(40);
  } else {
    transR(20);
  }
}

int hoverdetect(){
  return hover;
}

void transR(float R){
  float t = 0.05;
  if( r == R ){
  } else {
    r += (R-r)*t;
  }
}

}
  
