package med.voll.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
  @RequestMapping
  public String indexContent() {
    return "Voll.med @ API";
  }
}
