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
package org.identityconnectors.framework.api.operations;

import org.identityconnectors.framework.common.objects.ConnectorObject;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptions;
import org.identityconnectors.framework.common.objects.Uid;

/**
 * Get a particular {@link ConnectorObject} based on the {@link Uid}.
 */
public interface GetApiOp extends APIOperation {

    /**
     * Get a particular {@link ConnectorObject} based on the {@link Uid}.
     * 
     * @param objClass
     *            type of object to get.
     * @param uid
     *            the unique id of the object that to get.
     * @param options
     *            additional options that impact the way this operation is run.
     *            May be null.
     * @return {@link ConnectorObject} based on the {@link Uid} provided or
     *            <code>null</code> if no such object could be found.
     */
    public ConnectorObject getObject(ObjectClass objClass, Uid uid, OperationOptions options);
}
