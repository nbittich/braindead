package tech.artcoded.braindead.rest.trait;

import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;

public interface BuildInfoControllerTrait {
  BuildProperties getBuildProperties();

  @GetMapping("/build-info")
  default BuildProperties getProperties() {
    return getBuildProperties();
  }
}