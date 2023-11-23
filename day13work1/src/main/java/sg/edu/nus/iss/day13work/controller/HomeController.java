package main.java.sg.edu.nus.iss.day13work.controller;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/pagea")
    public String PageA(Model model, HttpSession session) {
        if (session.getAttribute("myFullName") != null) {
            model.addAttribute("SessionData", session.getAttribute("myFullName").toString());
        } else {
            model.addAtrribute("SessionData", "There is no session object now.");
        }
        return "pagea";
    }

    @PostMapping("/pagea")
    public String PageAPost(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession session) {

        String myFullName = form.getFirst("fullname");
        System.out.println("My full name is " + myFullName);

        session.setAttribute("myFullName", myFullName);
        model.addAttribute("myName", session.getAttribute("myFullName").toString());

        return "pageb";
    }

    @GetMapping("/pageb")
    public String PageB(Model model, HttpSession session) {
        String myFullName = session.getAttribute("myFullName").toString();
        model.addAtrribute("myName", myFullName);

        return "pagec";
    }

    @PostMapping("/pagec")
    public String PageC(Model model, HttpSession session) {
        session.invalidate();

        return "pagea";
    }
}
