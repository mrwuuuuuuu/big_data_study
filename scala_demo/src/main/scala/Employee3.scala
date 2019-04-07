
package A {
  package B {
    package C {

      class Employee {
        private val phrase = "hello world,A_B_C:Employee"
        def getPhrase = phrase
      }
    }
  }
}

package D {
  package E {
    package F {

      class Employee {
        private val phrase = "hello world,D_E_F:Employee"
        def getPhrase = phrase
      }
    }
  }
}