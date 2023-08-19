#!groovy

import groovy.io.FileType
import groovy.json.JsonOutput

def jars = []
def home = System.properties['user.home']
def dir = new File("$home/.gradle/caches/modules-2/files-2.1")
dir.eachFileRecurse (FileType.FILES) { file ->
  if (file.name.endsWith('jar')) {
    jars << file.path
  }
}

def classpath = [groovy: [classpath: jars]]
def json = JsonOutput.toJson(classpath)

def groovySettings = new File("groovyls.json")
groovySettings.text = JsonOutput.prettyPrint(json)


// {
//   "groovy": {
//     "classpath": [
//       "/home/tsolval/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-test/3.0.2/b014e6596a04ce4aa374ca3cd6361489afab8680",
//       "/home/tsolval/.sdkman/candidates/groovy/current/lib",
//       "/home/tsolval/Repository/Sibia/dndbe_app/build/libs",
//       "./libs"
//     ]
//   }
// }
