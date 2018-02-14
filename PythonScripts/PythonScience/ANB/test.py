import pyanx

chart = pyanx.Pyanx()

tyrion = chart.add_node(entity_type='Circle', label='Tyrion')
tywin = chart.add_node(entity_type='Circle', label='Tywin', color='red')
jaime = chart.add_node(entity_type='Circle', label='Jaime', color='green')
cersei = chart.add_node(entity_type='Circle', label='Cersei', color='gray')

chart.add_edge(tywin, tyrion, 'Father of')
chart.add_edge(jaime, tyrion, 'Brother of')
chart.add_edge(cersei, tyrion, 'Sister of')

chart.create('test.anx')


