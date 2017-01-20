/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.core.writer;

import java.util.Collection;

/**
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public interface BatchWriter <O> extends IWriter<O>{
      /**
       * <p>writeData.</p>
       *
       * @param data a {@link java.util.Collection} object.
       * @return a boolean.
       */
      boolean writeData(Collection<O> data);
}
