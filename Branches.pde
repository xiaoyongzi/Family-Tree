class Tree{
  String[] main1 = {"e-Health","e-Business","e-Society","Human-Tech Interactions"};
  float[]  main2 ={0.27,0.18,0.21,0.34,0};
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
        branch1startx = -0.5*weight+0.5*branch1weight[0];
      } else {
        branch1startxadd += 0.5*(branch1weight[i]+branch1weight[i-1]);
        branch1startx = -0.5*weight+0.5*branch1weight[0]+branch1startxadd;
      }
      PVector branch1start = new PVector(branch1startx,0);
      branches[i] = new Branch(branch1start,branch1weight[i],i+1,100+i*20);
      //branches[i] = new Branch(branch1start,branch1weight[i],i+1,255);
    }
  }
  
   void play(boolean trigger1, boolean trigger2, boolean trigger3, boolean trigger4){
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
   
   void gethl(int highlight){
     this.highlight = highlight;
   }
   
   int gethighlight(){
    int [] hls = new int[branches.length];
    for(int i=0;i<branches.length;i++){
      hls[i] = branches[i].gethighlight();
    }
    int hlight = max(hls);
    return hlight;
  }
  
  int hoverdetct(){
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
  
  void gettm(int tmselect){
    this.tmselect = tmselect;
  }
  
}
    
    
