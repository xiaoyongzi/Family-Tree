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

void display(){
  strokeCap(SQUARE);
  strokeWeight(bezierstrokeWeight);
  stroke(strokecolor,200);
  noFill();
  bezier(Start.x,Start.y,StartCon.x,StartCon.y,EndCon.x,EndCon.y,End.x,End.y);
}

void setweight(float bezierstrokeWeight){
  this.bezierstrokeWeight = bezierstrokeWeight;
}

void setcolor(float strokecolor){
  this.strokecolor = strokecolor;
}

void transall(PVector Start1, PVector StartCon1, PVector EndCon1, PVector End1){
  update(Start, Start1);
  update(StartCon,StartCon1);
  update(End, End1);
  update(EndCon,EndCon1);
}

void transhalf(PVector Start1, PVector StartCon1, PVector EndCon1, PVector End1){
  Start = Start1;
  update(StartCon,StartCon1);
  update(End, End1);
  update(EndCon,EndCon1);

}

void transend(PVector End1, PVector EndCon1){
  update(End, End1);
  update(EndCon,EndCon1);
}

void update(PVector pos, PVector target){
  float vel = 0.05;
  PVector v= PVector.div((PVector.sub(target,pos)),1/vel);
  if(pos==target){
  }else{
   pos.add(v);
  }
}

PVector getEnd(){
  return End;   
}

PVector getEndcon(){
  return EndCon;   
}

}


