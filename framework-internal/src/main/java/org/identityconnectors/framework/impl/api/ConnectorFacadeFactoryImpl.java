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
package org.identityconnectors.framework.impl.api;

import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.api.APIConfiguration;
import org.identityconnectors.framework.api.ConnectorFacade;
import org.identityconnectors.framework.api.ConnectorFacadeFactory;
import org.identityconnectors.framework.common.exceptions.ConnectorException;
import org.identityconnectors.framework.impl.api.local.ConnectorPoolManager;
import org.identityconnectors.framework.impl.api.local.LocalConnectorFacadeImpl;
import org.identityconnectors.framework.impl.api.local.LocalConnectorInfoImpl;
import org.identityconnectors.framework.impl.api.remote.RemoteConnectorFacadeImpl;

public class ConnectorFacadeFactoryImpl extends ConnectorFacadeFactory {

    private static final Log LOG = Log.getLog(ConnectorFacadeFactoryImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public ConnectorFacade newInstance(final APIConfiguration config) {
        ConnectorFacade ret = null;
        final APIConfigurationImpl impl = (APIConfigurationImpl) config;
        final AbstractConnectorInfo connectorInfo = impl.getConnectorInfo();
        if (connectorInfo instanceof LocalConnectorInfoImpl) {
            final LocalConnectorInfoImpl localInfo = (LocalConnectorInfoImpl) connectorInfo;
            try {
                // create a new Provisioner..
                ret = new LocalConnectorFacadeImpl(localInfo, impl);
            } catch (Exception e) {
                LOG.error(e, "Failed to create new connector facade: {0}, {1}",
                        impl.getConnectorInfo().getConnectorKey().toString(), config);
                throw ConnectorException.wrap(e);
            }
        } else {
            ret = new RemoteConnectorFacadeImpl(impl);
        }
        return ret;
    }

    /**
     * Dispose of all object pools and other resources associated with this class.
     */
    @Override
    public void dispose() {
        ConnectorPoolManager.dispose();
    }
}
