package org.zhaogang.eagleeye.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.Scheduler;
import akka.cluster.Cluster;
import org.zhaogang.eagleeye.log.AkkaLogstashAdapter;
import scala.concurrent.ExecutionContext;

/**
 * Created by Joy.wang on 16-5-23.
 */
public class BaseActor extends AbstractLoggingActor {
    protected ActorSystem system = this.context().system();
    protected Scheduler scheduler;
    protected ExecutionContext executionContext;
    protected final AkkaLogstashAdapter log;
    protected Address clusterAddress;
    protected String actorSystemName;

    public BaseActor() {
        this.scheduler = this.system.scheduler();
        this.executionContext = this.system.dispatcher();
        this.log = AkkaLogstashAdapter.getLogger(this);
        this.clusterAddress = Cluster.get(this.getContext().system()).selfAddress();
        this.actorSystemName = this.system.name();
    }
}
