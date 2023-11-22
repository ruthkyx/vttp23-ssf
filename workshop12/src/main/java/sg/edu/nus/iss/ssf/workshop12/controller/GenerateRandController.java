package main.java.sg.edu.nus.iss.ssf.workshop12.controller;

import java.util.Iterator;

@Controller
@RequestMapping(path="/rand")
public class GenerateRandController {

    @GetMapping(path="/show")
    public String showRandomForm(Model m) {
        Generate g = new Generate();
        m.addAttribute("generateObj", g);
        return "generate";
    }
    
    @GetMapping(path="/generate")
public String generate(@RequestParam Integer numberVal, Model m) {
    this.randomizeNumber(m, numberVal.intValue());
    return "result";
}

private void randomizeNumber (Model m, int noOfGenerateNo) {
    int maxGenNo = 31;

    // placeholder to hold all the img numbers
    String[] imgNumbers = new String[maxGenNo];

    // validate noOfGenerateno cannot be less tahn 1 and gt 30
    if (noOfGenerateNo < 1 || noOfGenerateNo > maxGenNo -1) {
        throw new RandNoException();
    }
    // gen numeber imgs filename and set to the array 
    for(inx =0; x < maxGenNo; x++){
        imgNumbers[x] = "number" + x + ".jpg";
    }
    List <String> selectedImgs = new Arraylist<String>();
    Random rand = new Random();
    //linkedhashset is faster
    Set<Integer> uniqueResult = new LinkedHashSet<Integer>();
    while(uniqueResult.size() < noOfGenerateNo) {
        Integer randNoResult = rand.nextInt(maxGenNo);
        if(randNoResult != null) {
            uniqueResult.add(randNoResult);
        }
    }

    Integer currElem= null;
    for(Iterator<E> iter = uniquResult.iterator(); iter.hasNext();) {
        currElem = (Integer)iter.next();
        selectedImgs.add(imgNumbers[currElem]);
    }

    m.addAttribute("noOfGenerateno", currElem);
    m.addAttribute("selectedImgs", selectedImgs);
}

}
