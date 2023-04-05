package net.tsolval.dndbe.service

import org.junit.jupiter.api.Test

class EventServiceTest {

    EventService service = new EventService()

    @Test
    void testNegativeEventFocus() {
        assert 'Combat' == service.eventFocusNegative(1)
        assert 'Combat' == service.eventFocusNegative(2)
        assert 'Combat' == service.eventFocusNegative(3)
        assert 'Combat' == service.eventFocusNegative(4)
        assert 'Combat' == service.eventFocusNegative(5)
        assert 'Combat' == service.eventFocusNegative(6)
        assert 'Combat' == service.eventFocusNegative(7)
        assert 'Objective Negative' == service.eventFocusNegative(8)
        assert 'Objective Negative' == service.eventFocusNegative(9)
        assert 'Objective Negative' == service.eventFocusNegative(10)
        assert 'NPC Negative' == service.eventFocusNegative(11)
        assert 'NPC Negative' == service.eventFocusNegative(12)
        assert 'NPC Negative' == service.eventFocusNegative(13)
        assert 'NPC Negative' == service.eventFocusNegative(14)
        assert 'PC Negative' == service.eventFocusNegative(15)
        assert 'PC Negative' == service.eventFocusNegative(16)
        assert 'PC Negative' == service.eventFocusNegative(17)
        assert 'Instigate' == service.eventFocusNegative(18)
        assert 'Background Negative' == service.eventFocusNegative(19)
        assert 'Magic Item Negative' == service.eventFocusNegative(20)
    }

    @Test
    void testNeutralPositiveEventFocus() {
        assert 'Remote Event' == service.eventFocusPositive(1)
        assert 'Remote Event' == service.eventFocusPositive(2)
        assert 'Ambiguous Event' == service.eventFocusPositive(3)
        assert 'Ambiguous Event' == service.eventFocusPositive(4)
        assert 'New NPC' == service.eventFocusPositive(5)
        assert 'New NPC' == service.eventFocusPositive(6)
        assert 'NPC Action' == service.eventFocusPositive(7)
        assert 'NPC Action' == service.eventFocusPositive(8)
        assert 'NPC Action' == service.eventFocusPositive(9)
        assert 'NPC Action' == service.eventFocusPositive(10)
        assert 'NPC Action' == service.eventFocusPositive(11)
        assert 'NPC Action' == service.eventFocusPositive(12)
        assert 'NPC Action' == service.eventFocusPositive(13)
        assert 'NPC Action' == service.eventFocusPositive(14)
        assert 'NPC Positive' == service.eventFocusPositive(15)
        assert 'PC Positive' == service.eventFocusPositive(16)
        assert 'Magic Item Positive' == service.eventFocusPositive(17)
        assert 'Background Positive' == service.eventFocusPositive(18)
        assert 'Objective Positive' == service.eventFocusPositive(19)
        assert 'Objective Positive' == service.eventFocusPositive(20)
    }
}
