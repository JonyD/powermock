/*
 *
 *   Copyright 2003 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.powermock.api.mockito.repackaged.cglib.transform;

import org.powermock.api.mockito.repackaged.asm.ClassReader;
import org.powermock.api.mockito.repackaged.cglib.core.ClassGenerator;

public class TransformingClassLoader extends AbstractClassLoader {
    private ClassTransformerFactory t;
    
    public TransformingClassLoader(ClassLoader parent, ClassFilter filter, ClassTransformerFactory t) {
        super(parent, parent, filter);
        this.t = t;
    }

    protected ClassGenerator getGenerator(ClassReader r) {
        ClassTransformer t2 = t.newInstance();
        return new TransformingClassGenerator(super.getGenerator(r), t2);
    }
}