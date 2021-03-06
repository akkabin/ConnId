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

import org.identityconnectors.framework.api.APIConfiguration;
import org.identityconnectors.framework.api.operations.APIOperation;

/**
 * Thrown when an {@link APIOperation operation} <i>times out</i>.
 * The framework cancels an operation when the corresponding method 
 * has been executing for longer than the
 * {@link APIConfiguration#setTimeout limit specified in APIConfiguration}.
 */
public class OperationTimeoutException extends ConnectorException {
    
    private static final long serialVersionUID = 1L;

    public OperationTimeoutException() {
        super();
    }
    
    public OperationTimeoutException(String msg) {
        super(msg);
    }
    
    public OperationTimeoutException(Throwable e) {
        super(e);
    }
    
    public OperationTimeoutException(String msg, Throwable e) {
        super(msg,e);
    }

}
