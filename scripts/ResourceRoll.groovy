class ResourceRoll {
  def faces
  def level
  def rolls

  static void main (String[] args) {
    def rr = new ResourceRoll()
    println rr.testResourceDie(4)
    println rr.testResourceDie(6)
    println rr.testResourceDie(8)
    println rr.testResourceDie(10)
    println rr.testResourceDie(12)
  }

  def testResourceDie(def size) {
    // test resources x times
    def results = (0..1000000).collect{expendResource(size)}.sort()
    def count = results.size()
    def min = results.min()
    def max = results.max()
    def avg = results.sum() / count
    def med = results[count/2]
    def ltmed = (results.findAll {it < med/2}.size() / count) * 100 as int
    def gtmed = (results.findAll {it > med*2}.size() / count) * 100 as int
    "Die: d${size}, Count: ${count}, Min: ${min}, Max: ${max}, Avg: ${avg}, Med: ${med}, #> med: ${gtmed}%, #< med: ${ltmed}%"
  }

  def expendResource(def faces) {
    this.faces = faces
    this.level = faces
    this.rolls = 0

    // stop when level = 0
    while(level > 0) {
      // increment count
      rolls++
      // roll die
      def roll = new Random().nextInt(faces)+1
      // adjust level based on result
      adjustLevel roll
    }
    
    // return count
    return rolls
  }

  def adjustLevel (def roll) {
    // adjustLevelWhenLessThanOrEqualTo roll
    // adjustLevelWhenLessThan roll
    adjustLevelUnlessMax roll
  }

// Die: d4,  Min: 4,  Max: 130, Avg: 12.8948201052, Med: 10, #> med: 15%, #< med: 7%                                             
// Die: d6,  Min: 6,  Max: 176, Avg: 21.7677622322, Med: 18, #> med: 12%, #< med: 7%                                             
// Die: d8,  Min: 8,  Max: 282, Avg: 31.3638656361, Med: 27, #> med: 10%, #< med: 7%                                             
// Die: d10, Min: 10, Max: 367, Avg: 41.5231674768, Med: 36, #> med: 9%,  #< med: 5%                                            
// Die: d12, Min: 12, Max: 354, Avg: 52.0874969125, Med: 45, #> med: 8%,  #< med: 5%
  def adjustLevelWhenLessThanOrEqualTo (def roll){
    if (roll == faces) {
      level = Math.min(level + 1, faces)
    } else if (roll <= level) {
      level -= 1
    }
  }

// Die: d4,  Min: 4,  Max: 223, Avg: 21.3245786754, Med: 16, #> med: 18%, #< med: 14%                                            
// Die: d6,  Min: 6,  Max: 538, Avg: 36.4919215081, Med: 29, #> med: 15%, #< med: 14%                                            
// Die: d8,  Min: 8,  Max: 627, Avg: 51.7797782202, Med: 42, #> med: 14%, #< med: 12%                                            
// Die: d10, Min: 10, Max: 630, Avg: 67.5108474892, Med: 55, #> med: 13%, #< med: 11%                                          
// Die: d12, Min: 12, Max: 759, Avg: 83.6372453628, Med: 69, #> med: 13%, #< med: 10%
  def adjustLevelWhenLessThan (def roll) {
    if (roll == faces) {
      level = Math.min(level + 1, faces)
    } else if (roll < level || roll == 1) {
      level -= 1
    }
  }

// Die: d4,  Min: 4,  Max: 50, Avg: 7.0169319831,  Med: 6,  #> med: 7%, #< med: 0%                                                 
// Die: d6,  Min: 6,  Max: 41, Avg: 8.6276303724,  Med: 8,  #> med: 2%, #< med: 0%                                                 
// Die: d8,  Min: 8,  Max: 40, Avg: 10.4470815529, Med: 10, #> med: 0%, #< med: 0%                                               
// Die: d10, Min: 10, Max: 38, Avg: 12.3447006553, Med: 12, #> med: 0%, #< med: 0%                                             
// Die: d12, Min: 12, Max: 38, Avg: 14.2766917233, Med: 14, #> med: 0%, #< med: 0%
def adjustLevelUnlessMax (def roll) {
    if (roll == faces) {
      level = Math.min(level + 1, faces)
    } else {
      level -= 1
    }
  }
}

