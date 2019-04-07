package A {
  package B {
    package C {

      object Utils {
        def printStr(str: String): Unit = {
          println(str)
        }
      }

      package D {
        package E {

          class Employee(val name: String, val salary: Double) {
          }

          object Employee {
            def apply(name: String, salary: Double): Employee = {
              val x = new Employee(name, salary)
              x
            }
            def printInfo(e: Employee): Unit = {
              Utils.printStr("[" + e.name + "," + e.salary + "]")
            }
          }

        }

      }


    }

  }

}
