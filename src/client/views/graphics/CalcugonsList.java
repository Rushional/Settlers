package client.views.graphics;

import java.awt.*;
import java.util.List;

// At this point you might think I'm going nuts. Well, maybe I am and maybe I am not, but hear me out!
// drawings on the map in this project are immutable. And I'm kinda scared of trying to access them
// and try to use those polygons to calculate things. Those are redrawn and recreated all the time,
// and I have no idea what might go wrong if I try to use those. I mean, I get one of them, do something,
// but by the time I`m finished those polygons are long gone, and the drawing consists of entirely new Polygons.
// And well, it shouldn't matter, because coordinates don't change. But instead of trying to calculate
// my stuff with dated polygons, I decided to make CALCUGONS. These are awt polygons used for calculations
// and not are not drawn.
// So, you've heard my story, and now you know my reasons... So you be the judge
public class CalcugonsList {
    private List<Polygon> calcugonsList;

    public CalcugonsList() {

    }
}
// I think by the time this project is done the names of the classes will be absolutely beyond human understanding
// This project will become some terrible otherworldly abomination