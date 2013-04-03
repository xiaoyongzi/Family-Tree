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
  float middlelevel=-0.18*height;
  float toplevel = -0.3*height;
  float branch1border=width/6;
  float branch2width = 0.22*(width-2*branch1border);
  PVector downvector1 = new PVector(0, -(middlelevel/2));
  PVector upvector1 = new PVector(0, (middlelevel/2));
  
   PVector downvector4 = new PVector(0, -1.1*(middlelevel));
  PVector upvector4 = new PVector(0, (middlelevel/1.6));
  
  PVector downvector2 = new PVector(0, -((toplevel-middlelevel)/2));
  PVector upvector2 = new PVector(0, ((toplevel-middlelevel)/1.5));
  
    PVector downvector3 = new PVector(0, -((toplevel-middlelevel)*2));
  PVector upvector3 = new PVector(0, ((toplevel-middlelevel)*1.3));
  
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
        branch2startxadd += 0.5*(branch2weighti + branch2weightii); 
      }
      
      float branch2startx = branch1end.x - branch1weight/2 + branch2weighti/2 + branch2startxadd;
      PVector branch2start = new PVector(branch2startx, branch1end.y+0.5);
      float branch2endx = branch1end.x-0.5*branch2width+branch2width*i/(num-1);
      PVector branch2end = new PVector(branch2endx,toplevel);
      PVector branch2startcon = PVector.add(branch2start,upvector2);
      PVector branch2endcon = PVector.add(branch2end,downvector2);
      
      branch2[i] = new Gbezier(branch2start, branch2startcon, branch2endcon, branch2end);
      branch2[i].setweight(branch2weighti);
      branch2[i].setcolor(gray);
      theories[i] = new Theory(branch2end, 20, branch2data[0][i]);
    }
  }
  
  String[] subblank(String[] array){
    for(int i=array.length-1; i>0; i--){
    if(array[array.length-1].equals("")){
      array = subset(array,0,array.length-1);
    }
  }
  return array;
  }
      
  
  void display(){
    for(int i=0;i<num;i++){
      branch2[i].display();
      theories[i].display(tmselect);
    }
     branch1.display();
     //println(gethighlight());   
  }
  
  void trans(boolean ok){
    PVector branch1endnew;
    PVector branch1endconnew;
    if(ok){
      middlelevel = -0.3*height;
      toplevel = -0.54*height;
      branch1endnew= new PVector( leftbranch1endx + (branch1index-1) * branch1interval, middlelevel);
      branch1endconnew = PVector.add(branch1endnew,downvector4);
    } else {
      middlelevel= -0.18*height;
      toplevel = -0.3*height;
       branch1endnew = new PVector( leftbranch1endx + (branch1index-1) * branch1interval, middlelevel,0 );
      branch1endconnew = PVector.add(branch1end,downvector1);
      
    }
     branch1.transend(branch1endnew,branch1endconnew);
      run(ok);
  }

  void run(boolean okk){
    float branch2startxadd = 0;    
    for(int i=0; i<num; i++){
      float branch2weighti;
      float branch2weightii;
      if(i==0){
        branch2weighti = weight * parseFloat(branch2data[1][i]); 
      } else {
        branch2weighti = weight * parseFloat(branch2data[1][i]);
        branch2weightii = weight * parseFloat(branch2data[1][i-1]);
        branch2startxadd += 0.5*(branch2weighti + branch2weightii); 
      }
      float branch2startx = branch1end.x - 0.5*branch1weight + 0.5*(weight * parseFloat(branch2data[1][0])) + branch2startxadd;
      PVector branch2start = new PVector(branch2startx-0.1, branch1end.y+0.15);
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
        branch2endx = branch1end.x-0.5*branch2width+branch2width*i/(num-1);
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
  
  
  void gethl(int highlight){
    this.highlight = highlight;
  }
  
  int gethighlight(){
    int [] hls = new int[num];
    for(int i=0;i<num;i++){
      hls[i] = theories[i].gethighlight();
    }
    int hlight = max(hls);
    return hlight;
  }
  
  
  int hoverdetect(){
    int [] hoverd = new int[num];
    for(int i=0;i<num;i++){
      hoverd[i] = theories[i].hoverdetect();
    }
    int hover = max(hoverd);
    return hover;
  }
  
  void label(String name, float percent){
    //textFont(font,20);
    fill(86,170,230);
    textAlign(CENTER,CENTER);
    //rectMode(CENTER);
    //text(parseInt(percent*100)+"%  "+name,leftbranch1endx + (branch1index-1) * branch1interval,40);
  }
  
  void tmdetect(int tmselect){
    this.tmselect = tmselect;
  }
}
