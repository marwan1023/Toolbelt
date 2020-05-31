/* -*- c++ -*- */
/* 
 * Copyright 2020 MJ.
 * 
 * This is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3, or (at your option)
 * any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this software; see the file COPYING.  If not, write to
 * the Free Software Foundation, Inc., 51 Franklin Street,
 * Boston, MA 02110-1301, USA.
 */

#ifdef HAVE_CONFIG_H
#include "config.h"
#endif

#include <gnuradio/io_signature.h>
#include "cognitive_impl.h"

namespace gr {
  namespace my_module {

    cognitive::sptr
    cognitive::make()
    {
      return gnuradio::get_initial_sptr
        (new cognitive_impl());
    }

    /*
     * The private constructor
     */
    cognitive_impl::cognitive_impl()
      : gr::block("cognitive",
              gr::io_signature::make(1, 1, sizeof(float)),
              gr::io_signature::make(1, 1, sizeof(float)))
    {
        state = 0;
        cnt = 0;
        set_max_noutput_items(1);
        set_max_output_buffer(2);

    }

    /*
     * Our virtual destructor.
     */
    cognitive_impl::~cognitive_impl()
    {
    }

    void
    cognitive_impl::forecast (int noutput_items, gr_vector_int &ninput_items_required)
    {
      ninput_items_required[0] = noutput_items;
    }

    int
    cognitive_impl::general_work (int noutput_items,
                       gr_vector_int &ninput_items,
                       gr_vector_const_void_star &input_items,
                       gr_vector_void_star &output_items)
    {
      const float *in = (const float *) input_items[0];
      float *out = (float *) output_items[0];

      for(int i=0; i < noutput_items; i++)
      {
        if (state == 0 && in[i] >= 10)
        {
          state = 1;
        }
        else if (state == 1 && in[1] <= 5)
        {
          state = 2;
        }
        else if (state == 2 && in[1] >= 10)
        {
          state = 3;
        }
        else if (state == 3 && in[1] <= 5)
        {
          state = 0;
        }

        if(state == 0 || state == 3)
        {
          out[i] = 4530000000;
        }
        else if (state == 1 || state == 2)
        {
          out[i] = 4330000000;
        }
      }

      // Do <+signal processing+>
      // Tell runtime system how many input items we consumed on
      // each input stream.
      consume_each (noutput_items);

      // Tell runtime system how many output items we produced.
      return noutput_items;
    }

  } /* namespace my_module */
} /* namespace gr */

