/**
 * ====================
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2008-2009 Sun Microsystems, Inc. All rights reserved.
 * Copyright 2011-2013 Tirasa. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License("CDDL") (the "License"). You may not use this file
 * except in compliance with the License.
 *
 * You can obtain a copy of the License at https://oss.oracle.com/licenses/CDDL
 * See the License for the specific language governing permissions and limitations
 * under the License.
 *
 * When distributing the Covered Code, include this CDDL Header Notice in each file
 * and include the License file at https://oss.oracle.com/licenses/CDDL.
 * If applicable, add the following below this CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * ====================
 */
package org.identityconnectors.framework.common.exceptions;

import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.Uid;

/**
 * Thrown when a {@link Uid} that is specified as input to a connector operation
 * identifies no object on the target resource.
 */
public class UnknownUidException extends InvalidCredentialException {
    private static final String MSG = "Object with Uid '%s' and ObjectClass '%s' does not exist!";    
    private static final long serialVersionUID = 1L;

    public UnknownUidException() {
        super();
    }

    public UnknownUidException(Uid uid, ObjectClass objclass) {
        super(String.format(MSG, uid, objclass));
    }
    public UnknownUidException(String message) {
        super(message);
    }
    
    public UnknownUidException(Throwable ex) {
        super(ex);
    }

    public UnknownUidException(String message, Throwable ex) {
        super(message, ex);
    }
}
