package org.automon.monitors;

import org.aspectj.lang.JoinPoint;

/**
 * Implementations of this interface can be called automatically by aspectJ pointcuts to monitor your system.
 */
public interface OpenMon<T> {
    /**
     * Called by aspectJ as part of aroundAdvice. It is typically used to start a timer, however anything could be done
     * such as logging the start of the method.
     *
     * @param jp The method name or any identifying context.
     * @return Any Object can be returned.  It will be passed back into the stop(..) method.  Typically this would be a timer
     * that can later be stopped.
     */
    public T start(JoinPoint jp);

    /**
     * Called as part of AspectJ's 'around' advice.  It is called after the event such as a method has completed. Typically
     * a timer that was started in the 'start' method above would be stopped.  Although anything can be done.
     *
     * @param context The object returned by 'start' is passed in.  Typically this would be a timer and should be stopped.
     *              Note although this variable is typically a 'timer' it can really be any object, or state needed.
     */
    public void stop(T context);


    /**
     * Called as part of AspectJ's 'around' advice.  It is called after the event such as a method has completed. Typically
     * a timer that was started in the 'start' method above would be stopped.  Although anything can be done.
     *
     * @param context The object returned by 'start' is passed in.  Typically this would be a timer and should be stopped.
     *              Note although this variable is typically a 'timer' it can really be any object, or state needed.
     */
    public void stop(T context, Throwable throwable);

    /**
     * Nofitication that an exception has occurred. Typically the implementing class would count exceptions though anything is possible.
     *
     * @param label The name identifier for the exception.
     */
    public void exception(String label);

}
