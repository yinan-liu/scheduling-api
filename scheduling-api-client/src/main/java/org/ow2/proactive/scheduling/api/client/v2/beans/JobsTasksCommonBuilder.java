/*
 *  *
 * ProActive Parallel Suite(TM): The Java(TM) library for
 *    Parallel, Distributed, Multi-Core Computing for
 *    Enterprise Grids & Clouds
 *
 * Copyright (C) 1997-2015 INRIA/University of
 *                 Nice-Sophia Antipolis/ActiveEon
 * Contact: proactive@ow2.org or contact@activeeon.com
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; version 3 of
 * the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 *
 *  Initial developer(s):               The ProActive Team
 *                        http://proactive.inria.fr/team_members.htm
 *  Contributor(s):
 *
 *  * $$ACTIVEEON_INITIAL_DEV$$
 */
package org.ow2.proactive.scheduling.api.client.v2.beans;

import java.util.List;
import java.util.function.Supplier;

import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.CURSOR;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.DESCRIPTION;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.FINISHED_TIME;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.ID;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.IN_ERROR_TIME;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.MAX_NUMBER_OF_EXECUTION;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.ON_TASK_ERROR;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.START_TIME;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.STATUS;
import static org.ow2.proactive.scheduling.api.client.v2.beans.Constants.RETURN;

public abstract class JobsTasksCommonBuilder {

    protected boolean cursor = true;
    protected boolean description = true;
    protected boolean finishedTime = true;
    protected GenericInformation genericInformation = new GenericInformation.Builder().build();
    protected boolean id = true;
    protected boolean inErrorTime = true;
    protected boolean maxNumberOfExecution = true;
    protected boolean name = true;
    protected boolean onTaskError = true;
    protected PageInfo pageInfo = new PageInfo.Builder().build();
    protected boolean startTime = true;
    protected boolean status = true;
    protected Variables variables = new Variables.Builder().build();

    protected StringBuilder sb = new StringBuilder();

    public JobsTasksCommonBuilder excludeCursor() {
        this.cursor = false;
        return this;
    }

    public JobsTasksCommonBuilder excludeDescription() {
        this.description = false;
        return this;
    }

    public JobsTasksCommonBuilder excludeFinishedTime() {
        this.finishedTime = false;
        return this;
    }

    public JobsTasksCommonBuilder excludeGenericInformation() {
        this.genericInformation = null;
        return this;
    }

    public JobsTasksCommonBuilder excludeId() {
        this.id = false;
        return this;
    }

    public JobsTasksCommonBuilder excludeInErrorTime() {
        this.inErrorTime = false;
        return this;
    }

    public JobsTasksCommonBuilder excludeMaxNumberOfExecution() {
        this.maxNumberOfExecution = false;
        return this;
    }

    public JobsTasksCommonBuilder excludeOnTaskError() {
        this.onTaskError = false;
        return this;
    }

    public JobsTasksCommonBuilder excludePageInfo() {
        this.pageInfo = null;
        return this;
    }

    public JobsTasksCommonBuilder excludeStartTime() {
        this.startTime = false;
        return this;
    }

    public JobsTasksCommonBuilder excludeStatus() {
        this.status = false;
        return this;
    }

    public JobsTasksCommonBuilder excludeVariables() {
        this.variables = null;
        return this;
    }

    public JobsTasksCommonBuilder genericInformation(GenericInformation genericInformation) {
        this.genericInformation = genericInformation;
        return this;
    }

    public JobsTasksCommonBuilder pageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    public JobsTasksCommonBuilder variables(Variables variables) {
        this.variables = variables;
        return this;
    }

    public void build(Supplier<String> title, List<? extends ApiType> input) {
        sb.append(title.get());
        sb.append(Inputs.buildQueryString(input));
        sb.append("{").append(RETURN);
        if (pageInfo != null) {
            sb.append(pageInfo.getQueryString());
        }
        sb.append("edges{").append(RETURN);

        if (cursor) {
            sb.append(CURSOR.getKey()).append(RETURN);
        }

        sb.append("node{").append(RETURN);

        if (description) {
            sb.append(DESCRIPTION.getKey()).append(RETURN);
        }
        if (finishedTime) {
            sb.append(FINISHED_TIME.getKey()).append(RETURN);
        }
        if (genericInformation != null) {
            sb.append(genericInformation.getQueryString()).append(RETURN);
        }
        if (id) {
            sb.append(ID.getKey()).append(RETURN);
        }
        if (inErrorTime) {
            sb.append(IN_ERROR_TIME.getKey()).append(RETURN);
        }
        if (maxNumberOfExecution) {
            sb.append(MAX_NUMBER_OF_EXECUTION.getKey()).append(RETURN);
        }
        if (name) {
            sb.append(ApiTypeKeyEnum.NAME.getKey()).append(RETURN);
        }
        if (onTaskError) {
            sb.append(ON_TASK_ERROR.getKey()).append(RETURN);
        }
        if (startTime) {
            sb.append(START_TIME.getKey()).append(RETURN);
        }
        if (status) {
            sb.append(STATUS.getKey()).append(RETURN);
        }
        if (variables != null) {
            sb.append(variables.getQueryString());
        }
    }

}