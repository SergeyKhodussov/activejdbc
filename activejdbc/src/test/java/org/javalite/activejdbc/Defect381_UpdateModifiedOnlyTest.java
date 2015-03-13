/*
 * Copyright 2015 JavaLite.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.javalite.activejdbc;

import org.javalite.activejdbc.test.ActiveJDBCTest;
import org.javalite.activejdbc.test_models.Programmer;
import org.junit.Test;

/**
 *
 * @author Marcin Pikulski
 */
public class Defect381_UpdateModifiedOnlyTest extends ActiveJDBCTest {

    @Test
    public void isModifiedWhenModified() {
        Programmer prg = Programmer.createIt("first_name", "John");
        the(prg).shouldNotBe("new");
        the(prg).shouldNotBe("modified");
        prg.set("last_name", "Doe");
        the(prg).shouldBe("modified");
        prg.saveIt();
        the(prg).shouldNotBe("modified");
    }
    
    @Test
    public void isModifiedAfterCreated() {
        Programmer prg = Programmer.create("first_name", "John");
        the(prg).shouldBe("new");
        the(prg).shouldBe("modified");
        prg.set("last_name", "Doe");
        the(prg).shouldBe("modified");
        prg.saveIt();
        the(prg).shouldNotBe("modified");
    }
    
}
